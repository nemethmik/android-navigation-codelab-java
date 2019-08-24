package com.example.android.codelabs.navigation;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.Builder;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeepLinkFragment extends Fragment {
   @Nullable
   public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.deeplink_fragment, container, false);
   }

   public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      TextView textView = (TextView)view.findViewById(R.id.text);
      Bundle arguments = this.getArguments();
      textView.setText((CharSequence)(arguments != null ? arguments.getString("myarg") : null));
      Button notificationButton = (Button)view.findViewById(R.id.send_notification_button);
      notificationButton.setOnClickListener(this::onClick);
   }
   public final void onClick(View it) {
      EditText editArgs = (EditText)getView().findViewById(R.id.args_edit_text);
      Bundle args = new Bundle();
      args.putString("myarg", editArgs.getText().toString());
      PendingIntent deeplink = FragmentKt.findNavController(DeepLinkFragment.this).createDeepLink().setDestination(R.id.deeplink_dest).setArguments(args).createPendingIntent();
      Context context = DeepLinkFragment.this.getContext();
      if (context != null) {
         NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
         if (VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("deeplink", (CharSequence)"Deep Links", NotificationManager.IMPORTANCE_HIGH));
         }
         Builder builder = new NotificationCompat.Builder(context, "deeplink")
                 .setContentTitle((CharSequence) "Navigation")
                 .setContentText((CharSequence) "Deep link to Android")
                 .setSmallIcon(R.drawable.ic_android)
                 .setContentIntent(deeplink)
                 .setAutoCancel(true);
         notificationManager.notify(0, builder.build());
      }
   }
}
