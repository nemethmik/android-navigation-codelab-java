package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.android.codelabs.navigation.databinding.HomeFragmentBinding;

public final class HomeFragment extends Fragment {
   @Nullable
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      this.setHasOptionsMenu(true);
       HomeFragmentBinding binding = HomeFragmentBinding.inflate(inflater);
       binding.setLifecycleOwner(this);
       NavOptions navOptions = new NavOptions.Builder().setEnterAnim(R.anim.slide_in_right)
               .setExitAnim(R.anim.slide_out_left).setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
               .build();
       binding.navigateDestinationButton.setOnClickListener(v -> {
//           Navigation.findNavController(v).navigate(R.id.flow_step_one_dest,null,navOptions)
           Navigation.findNavController(v).navigate(HomeFragmentDirections.nextAction().setFlowStepNumber(1),navOptions);
       });
       binding.navigateActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action));
//       binding.navigateDestinationButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.flow_step_one_dest));
//      return inflater.inflate(R.layout.home_fragment, container, false);
       return binding.getRoot();
   }

   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
   }

   public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
      inflater.inflate(R.menu.main_menu, menu);
   }
}
