package com.example.android.codelabs.navigation;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DeepLinkAppWidgetProvider extends AppWidgetProvider {
   public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
      Intrinsics.checkParameterIsNotNull(context, "context");
      Intrinsics.checkParameterIsNotNull(appWidgetManager, "appWidgetManager");
      Intrinsics.checkParameterIsNotNull(appWidgetIds, "appWidgetIds");
      RemoteViews remoteViews = new RemoteViews(context.getPackageName(), -1300038);
      Bundle args = new Bundle();
      args.putString("myarg", "From Widget");
      appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
   }
}
