package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FlowStepFragment extends Fragment {
   @Nullable
   public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      this.setHasOptionsMenu(true);
      Bundle arguments = this.getArguments();
      Integer flowStepNumber = arguments != null ? arguments.getInt("flowStepNumber") : null;
      if (flowStepNumber != null && flowStepNumber == 2) {
         return inflater.inflate(R.layout.flow_step_two_fragment, container, false);
      } else return inflater.inflate(R.layout.flow_step_one_fragment, container, false);
   }

   public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      view.findViewById(R.id.next_button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action));
   }
}
