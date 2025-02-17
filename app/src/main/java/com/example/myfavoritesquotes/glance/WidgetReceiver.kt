package com.example.myfavoritesquotes.glance

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.example.myfavoritesquotes.glance.wigdet.MainWidget

class WidgetReceiver : GlanceAppWidgetReceiver(){

    override val glanceAppWidget: GlanceAppWidget = MainWidget()
}