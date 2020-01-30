package com.arduia.template.sample1.def

import android.content.Context
import com.arduia.template.sample1.MainConfig
import com.arduia.template.sample1.framework.data.AppData
import com.arduia.template.sample1.framework.ui.MainScreen

class DefaultMainConfig(private val context: Context):MainConfig{
    override var mainScreen: MainScreen =  DefaultMainScreen(context)
    override var appData: AppData = DefaultAppData()
}