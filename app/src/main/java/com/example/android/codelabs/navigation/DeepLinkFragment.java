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
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeepLinkFragment extends Fragment {
   @Nullable
   public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      Intrinsics.checkParameterIsNotNull(inflater, "inflater");
      return inflater.inflate(R.layout.deeplink_fragment, container, false);
   }

   public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState) {
      Intrinsics.checkParameterIsNotNull(view, "view");
      super.onViewCreated(view, savedInstanceState);
      TextView textView = (TextView)view.findViewById(R.id.text);
      Intrinsics.checkExpressionValueIsNotNull(textView, "textView");
      Bundle var10001 = this.getArguments();
      textView.setText((CharSequence)(var10001 != null ? var10001.getString("myarg") : null));
      Button notificationButton = (Button)view.findViewById(R.id.send_notification_button);
      notificationButton.setOnClickListener((OnClickListener)(new OnClickListener() {
         public final void onClick(View it) {
            EditText editArgs = (EditText)view.findViewById(R.id.args_edit_text);
            Bundle args = new Bundle();
            args.putString("myarg", editArgs.getText().toString());
            PendingIntent var10000 = FragmentKt.findNavController(DeepLinkFragment.this).createDeepLink().setDestination(R.id.deeplink_dest).setArguments(args).createPendingIntent();
            Intrinsics.checkExpressionValueIsNotNull(var10000, "findNavController().crea…   .createPendingIntent()");
            PendingIntent deeplink = var10000;
            Context var7 = DeepLinkFragment.this.getContext();
            Object var8 = var7 != null ? var7.getSystemService(Context.NOTIFICATION_SERVICE) : null;
            if (var8 == null) {
               throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
            } else {
               NotificationManager notificationManager = (NotificationManager)var8;
               if (VERSION.SDK_INT >= 26) {
                  notificationManager.createNotificationChannel(new NotificationChannel("deeplink", (CharSequence)"Deep Links", NotificationManager.IMPORTANCE_HIGH));
               }

               Builder var9;
               Context var10002 = DeepLinkFragment.this.getContext();
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var9 = new NotificationCompat.Builder(var10002, "deeplink");
               Builder builder = var9
                       .setContentTitle((CharSequence)"Navigation")
                       .setContentText((CharSequence)"Deep link to Android")
                       .setSmallIcon(-700072)
                       .setContentIntent(deeplink)
                       .setAutoCancel(true);
               notificationManager.notify(0, builder.build());

//               val builder = NotificationCompat.Builder(
//                       context!!, "deeplink")
//                    .setContentTitle("Navigation")
//                       .setContentText("Deep link to Android")
//                       .setSmallIcon(R.drawable.ic_android)
//                       .setContentIntent(deeplink)
//                       .setAutoCancel(true)
//               notificationManager.notify(0, builder.build())

            }
         }
      }));
   }
}
