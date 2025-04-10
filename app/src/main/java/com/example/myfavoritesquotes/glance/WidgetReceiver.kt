package com.example.myfavoritesquotes.glance

import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.paging.LoadState.Loading
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.myfavoritesquotes.data.repository.QuotesRepository
import com.example.myfavoritesquotes.glance.wigdet.MainWidget
import java.util.concurrent.TimeUnit

class WidgetReceiver : GlanceAppWidgetReceiver(){

    override val glanceAppWidget: GlanceAppWidget = MainWidget()
}


