package com.example.android.codelabs.navigation;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;

public final class DeepLinkAppWidgetProvider extends AppWidgetProvider {
   public void onUpdate(@NonNull Context context, @NonNull AppWidgetManager appWidgetManager, @NonNull int[] appWidgetIds) {
      RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.deep_link_appwidget);
      Bundle args = new Bundle();
      args.putString("myarg", "From Widget");
      appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
   }
}
