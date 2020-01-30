package com.arduia.template.sample1.framework

import android.view.View
import com.arduia.template.sample1.MainConfig
import com.arduia.template.sample1.TemplateContext

object AppConfiguration {
    var username = "admin"
    var password = "1234"
    var customPage:View?=null

    var inject :((config:MainConfig,ctx:TemplateContext)->MainConfig)?= null
}