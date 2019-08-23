package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"},
   d2 = {"Lcom/example/android/codelabs/navigation/FlowStepFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_debug"}
)
public final class FlowStepFragment extends Fragment {
   @Nullable
   public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      Intrinsics.checkParameterIsNotNull(inflater, "inflater");
      this.setHasOptionsMenu(true);
      Bundle var10000 = this.getArguments();
      Integer flowStepNumber = var10000 != null ? var10000.getInt("flowStepNumber") : null;
      View var6;
      if (flowStepNumber != null) {
         if (flowStepNumber == 2) {
            var6 = inflater.inflate(R.layout.flow_step_two_fragment, container, false);
            return var6;
         }
      }

      var6 = inflater.inflate(R.layout.flow_step_one_fragment, container, false);
      return var6;
   }

   public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
      Intrinsics.checkParameterIsNotNull(view, "view");
      super.onViewCreated(view, savedInstanceState);
      view.findViewById(R.id.next_button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action));
   }
}
