package com.arduia.template.sample1.def

import android.content.Context
import com.arduia.template.sample1.framework.ui.Page
import com.arduia.template.sample1.framework.ui.PageHost

class DefaultPageHost(private val ctx:Context):PageHost{
    override val customPage: Page
        get() = DefaultCustomPage(ctx)
}