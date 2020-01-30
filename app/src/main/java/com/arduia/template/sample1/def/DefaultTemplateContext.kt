package com.arduia.template.sample1.def

import android.content.Context
import com.arduia.template.sample1.TemplateContext

class DefaultTemplateContext (ctx:Context):TemplateContext{
    override val context: Context = ctx
}