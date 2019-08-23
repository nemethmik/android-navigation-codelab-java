// MainActivity.java
package com.example.android.codelabs.navigation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavController.OnDestinationChangedListener;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.AppBarConfiguration.Builder;
import androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener;
import com.google.android.material.navigation.NavigationView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MainActivity extends AppCompatActivity {
   private AppBarConfiguration appBarConfiguration;
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(R.layout.navigation_activity);
      Toolbar toolbar = (Toolbar)this.findViewById(R.id.toolbar);
      this.setSupportActionBar(toolbar);
      NavHostFragment host = (NavHostFragment)this.getSupportFragmentManager()
              .findFragmentById(R.id.my_nav_host_fragment);
      if (host != null) {
         NavController navController = host.getNavController();
         this.appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
         this.setupActionBar(navController, this.appBarConfiguration);
         this.setupNavigationMenu(navController);
         this.setupBottomNavMenu(navController);
         navController.addOnDestinationChangedListener(this::onDestinationChanged);
      }
   }

   private final void setupBottomNavMenu(NavController navController) {
   }

   private final void setupNavigationMenu(NavController navController) {
   }

   private final void setupActionBar(NavController navController, AppBarConfiguration appBarConfig) {
   }

   public boolean onCreateOptionsMenu(@NotNull Menu menu) {
      boolean retValue = super.onCreateOptionsMenu(menu);
      NavigationView navigationView = (NavigationView)this.findViewById(R.id.nav_view);
      if (navigationView == null) {
         this.getMenuInflater().inflate(R.menu.overflow_menu, menu);
         return true;
      } else {
         return retValue;
      }
   }

   public boolean onOptionsItemSelected(@NotNull MenuItem item) {
      return super.onOptionsItemSelected(item);
   }
   public final void onDestinationChanged(@NotNull NavController navController
           , @NotNull NavDestination destination, @Nullable Bundle bundle) {
      String dest;
      try {
         dest = MainActivity.this.getResources().getResourceName(destination.getId());
      } catch (NotFoundException var7) {
         dest = Integer.toString(destination.getId());
      }
      Toast.makeText((Context)MainActivity.this, (CharSequence)("Navigated to " + dest), Toast.LENGTH_SHORT).show();
      Log.d("NavigationActivity", "Navigated to " + dest);
   }
}
