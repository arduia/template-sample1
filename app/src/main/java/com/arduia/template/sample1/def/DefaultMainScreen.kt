package com.arduia.template.sample1.def

import android.content.Context
import com.arduia.template.sample1.framework.ui.MainScreen
import com.arduia.template.sample1.framework.ui.PageHost

class DefaultMainScreen (private val ctx:Context):MainScreen{
    override val pageHost: PageHost
        get() = DefaultPageHost(ctx)
}