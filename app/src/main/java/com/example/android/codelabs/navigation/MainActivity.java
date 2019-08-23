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
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MainActivity extends AppCompatActivity {
   private AppBarConfiguration appBarConfiguration;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(R.layout.navigation_activity);
      Toolbar toolbar = (Toolbar)this.findViewById(R.id.toolbar);
      this.setSupportActionBar(toolbar);
      NavHostFragment var10000 = (NavHostFragment)this.getSupportFragmentManager()
              .findFragmentById(R.id.my_nav_host_fragment);

      if (var10000 != null) {
         NavHostFragment host = var10000;
         NavController var12 = host.getNavController();
         Intrinsics.checkExpressionValueIsNotNull(var12, "host.navController");
         NavController navController = var12;
         NavGraph var10001 = navController.getGraph();
         Intrinsics.checkExpressionValueIsNotNull(var10001, "navController.graph");
         NavGraph navGraph$iv = var10001;
//         DrawerLayout drawerLayout$iv = (DrawerLayout)null;
//         Function0 fallbackOnNavigateUpListener$iv = (Function0)MainActivity$onCreate$$inlined$AppBarConfiguration$1.INSTANCE;
//         AppBarConfiguration var13 = (new Builder(navGraph$iv)).setDrawerLayout(drawerLayout$iv).setFallbackOnNavigateUpListener((OnNavigateUpListener)(new MainActivity$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener$iv))).build();
//         AppBarConfiguration var13 = (new Builder(navGraph$iv))
//                 .setDrawerLayout(drawerLayout$iv)
//                 .setFallbackOnNavigateUpListener(
//                         (OnNavigateUpListener)
//                                 (new MainActivity$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener$iv)))
//                 .build();
//         Intrinsics.checkExpressionValueIsNotNull(var13, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
//         AppBarConfiguration var11 = var13;
         this.appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
         AppBarConfiguration var10002 = this.appBarConfiguration;
         if (var10002 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarConfiguration");
         }

         this.setupActionBar(navController, var10002);
         this.setupNavigationMenu(navController);
         this.setupBottomNavMenu(navController);
         navController.addOnDestinationChangedListener((OnDestinationChangedListener)(new OnDestinationChangedListener() {
            public final void onDestinationChanged(@NotNull NavController $noName_0, @NotNull NavDestination destination, @Nullable Bundle $noName_2) {
               Intrinsics.checkParameterIsNotNull($noName_0, "<anonymous parameter 0>");
               Intrinsics.checkParameterIsNotNull(destination, "destination");

               String var5;
               try {
                  var5 = MainActivity.this.getResources().getResourceName(destination.getId());
               } catch (NotFoundException var7) {
                  var5 = Integer.toString(destination.getId());
               }

               Toast.makeText((Context)MainActivity.this, (CharSequence)("Navigated to " + var5), Toast.LENGTH_SHORT).show();
               Log.d("NavigationActivity", "Navigated to " + var5);
            }
         }));
      }
   }

   private final void setupBottomNavMenu(NavController navController) {
   }

   private final void setupNavigationMenu(NavController navController) {
   }

   private final void setupActionBar(NavController navController, AppBarConfiguration appBarConfig) {
   }

   public boolean onCreateOptionsMenu(@NotNull Menu menu) {
      Intrinsics.checkParameterIsNotNull(menu, "menu");
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
      Intrinsics.checkParameterIsNotNull(item, "item");
      return super.onOptionsItemSelected(item);
   }
}
