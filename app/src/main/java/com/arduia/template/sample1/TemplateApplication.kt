package com.arduia.template.sample1

import android.app.Application
import com.arduia.template.sample1.def.DefaultTemplateContext
import com.arduia.template.sample1.framework.AppConfiguration
import com.arduia.template.sample1.framework.Template

abstract class TemplateApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        AppConfiguration.inject = {config,ctx->
            bind(ctx).inject(config)
        }
    }

    abstract fun bind(ctx:TemplateContext):Template

}