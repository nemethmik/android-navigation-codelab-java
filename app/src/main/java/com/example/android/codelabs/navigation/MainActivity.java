// MainActivity.java
package com.example.android.codelabs.navigation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavController.OnDestinationChangedListener;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.AppBarConfiguration.Builder;
import androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener;
import androidx.navigation.ui.NavigationUI;

import com.example.android.codelabs.navigation.databinding.NavigationActivityBinding;
import com.google.android.material.navigation.NavigationView;

import static androidx.navigation.Navigation.findNavController;

public final class MainActivity extends AppCompatActivity {
   private AppBarConfiguration appBarConfiguration;
   NavigationActivityBinding binding;
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = NavigationActivityBinding.inflate(getLayoutInflater());
      binding.setLifecycleOwner(this);
      setContentView(binding.getRoot());
      setSupportActionBar(binding.toolbar);
      NavController navController = Navigation.findNavController(this,R.id.my_nav_host_fragment);
      // TODO STEP 9.5 - Create an AppBarConfiguration with the correct top-level destinations
      //Builder appBarConfigurationBuilder = new AppBarConfiguration.Builder(navController.getGraph());
      Builder appBarConfigurationBuilder = new AppBarConfiguration.Builder(R.id.home_dest, R.id.deeplink_dest);
      if(binding.drawerLayout != null) appBarConfigurationBuilder.setDrawerLayout(binding.drawerLayout);
      appBarConfiguration = appBarConfigurationBuilder.build();
      // TODO END STEP 9.5
      setupActionBar(navController, appBarConfiguration);
      setupNavigationMenu(navController);
      setupBottomNavMenu(navController);
      navController.addOnDestinationChangedListener(this::onDestinationChanged);
   }

   private final void setupBottomNavMenu(NavController navController) {
      // TODO STEP 9.3 - Use NavigationUI to set up Bottom Nav
      // bottom navigation is not available in every layout configuration
      // make sure to check for null, otherwise you receive a null pointer exceptions in those cases
      if(binding.bottomNavView != null) {
         NavigationUI.setupWithNavController(binding.bottomNavView, navController);
      }
   }

   private final void setupNavigationMenu(NavController navController) {
      // TODO STEP 9.4 - Use NavigationUI to set up a Navigation View
      // In split screen mode, you can drag this view out from the left
      // This does NOT modify the actionbar
      if(binding.navView != null) {
         NavigationUI.setupWithNavController(binding.navView, navController);
      }
   }

   private final void setupActionBar(NavController navController, AppBarConfiguration appBarConfig) {
      // TODO STEP 9.6 - Have NavigationUI handle what your ActionBar displays
      // This allows NavigationUI to decide what label to show in the action bar
      // By using appBarConfig, it will also determine whether to
      // show the up arrow or drawer menu icon
      NavigationUI.setupActionBarWithNavController(this,navController, appBarConfig);
   }
   @Override
   public boolean onCreateOptionsMenu(@NonNull Menu menu) {
      boolean retValue = super.onCreateOptionsMenu(menu);
      //If we have no navigation view, just create an options menu
      if (binding.navView == null) {
         getMenuInflater().inflate(R.menu.overflow_menu, menu);
         //By default icons are not shown
         //see https://stackoverflow.com/questions/19750635/icon-in-menu-not-showing-in-android
         if(menu instanceof MenuBuilder){
            ((MenuBuilder)menu).setOptionalIconsVisible(true);
         }
         return true;
      } else {
         return retValue;
      }
   }
   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      // TODO STEP 9.2 - Have Navigation UI Handle the item selection
      // Have the NavigationUI look for an action or destination matching the menu
      // item id and navigate there if found.
      // Otherwise, bubble up to the parent.
      NavController navController = Navigation.findNavController(this,R.id.my_nav_host_fragment);
      return NavigationUI.onNavDestinationSelected(item,navController)
         || super.onOptionsItemSelected(item);
   }
   public final void onDestinationChanged(@NonNull NavController navController
           , @NonNull NavDestination destination, @Nullable Bundle bundle) {
      String dest;
      try {
         dest = MainActivity.this.getResources().getResourceName(destination.getId());
      } catch (NotFoundException e) {
         dest = Integer.toString(destination.getId());
      }
      Toast.makeText((Context)MainActivity.this, (CharSequence)("Navigated to " + dest), Toast.LENGTH_SHORT).show();
      Log.d("NavigationActivity", "Navigated to " + dest);
   }
   // TODO STEP 9.7 - Have NavigationUI handle up behavior in the ActionBar
   @Override
   public boolean onSupportNavigateUp() {
     // Allows NavigationUI to support proper up navigation or the drawer layout
     // drawer menu, depending on the situation
     return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.my_nav_host_fragment),appBarConfiguration)
       || super.onSupportNavigateUp();
   }
}
