package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public final class FlowStepFragment extends Fragment {
   @Nullable
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      this.setHasOptionsMenu(true);
      Bundle arguments = this.getArguments();
      Integer flowStepNumber = arguments != null ? arguments.getInt("flowStepNumber") : null;
      if (flowStepNumber != null && flowStepNumber == 2) {
         return inflater.inflate(R.layout.flow_step_two_fragment, container, false);
      } else return inflater.inflate(R.layout.flow_step_one_fragment, container, false);
   }

   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      view.findViewById(R.id.next_button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action));
   }
}
