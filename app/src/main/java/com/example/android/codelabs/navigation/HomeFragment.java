package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HomeFragment extends Fragment {
   @Nullable
   public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      Intrinsics.checkParameterIsNotNull(inflater, "inflater");
      this.setHasOptionsMenu(true);
      return inflater.inflate(R.layout.home_fragment, container, false);
   }

   public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
      Intrinsics.checkParameterIsNotNull(view, "view");
      super.onViewCreated(view, savedInstanceState);
   }

   public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
      Intrinsics.checkParameterIsNotNull(menu, "menu");
      Intrinsics.checkParameterIsNotNull(inflater, "inflater");
      inflater.inflate(R.menu.main_menu, menu);
   }
}
