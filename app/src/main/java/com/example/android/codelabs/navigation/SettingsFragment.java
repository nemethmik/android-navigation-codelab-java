package com.example.android.codelabs.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SettingsFragment extends Fragment {
   @Nullable
   public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      Intrinsics.checkParameterIsNotNull(inflater, "inflater");
      return inflater.inflate(R.layout.settings_fragment, container, false);
   }
}
