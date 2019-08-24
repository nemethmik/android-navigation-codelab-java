package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.android.codelabs.navigation.databinding.FlowStepOneFragmentBinding;
import com.example.android.codelabs.navigation.databinding.FlowStepTwoFragmentBinding;

public final class FlowStepFragment extends Fragment {
   @Nullable
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      this.setHasOptionsMenu(true);
      if (FlowStepFragmentArgs.fromBundle(getArguments()).getFlowStepNumber() == 2) {
         return FlowStepTwoFragmentBinding.inflate(inflater).getRoot();
      } else {
         return FlowStepOneFragmentBinding.inflate(inflater).getRoot();
      }
   }

   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      view.findViewById(R.id.next_button).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action));
   }
}
