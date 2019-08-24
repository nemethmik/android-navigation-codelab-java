package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.android.codelabs.navigation.databinding.HomeFragmentBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HomeFragment extends Fragment {
   @Nullable
   public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      this.setHasOptionsMenu(true);
       HomeFragmentBinding binding = HomeFragmentBinding.inflate(inflater);
       binding.setLifecycleOwner(this);
//       binding.navigateDestinationButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.flow_step_one_dest));
       binding.navigateDestinationButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.flow_step_one_dest));
//      return inflater.inflate(R.layout.home_fragment, container, false);
       return binding.getRoot();
   }

   public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
   }

   public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
      inflater.inflate(R.menu.main_menu, menu);
   }
}
