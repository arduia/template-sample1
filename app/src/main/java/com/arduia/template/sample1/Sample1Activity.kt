package com.arduia.template.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arduia.template.sample1.def.DefaultMainConfig
import com.arduia.template.sample1.def.DefaultTemplateContext
import com.arduia.template.sample1.framework.AppConfiguration

 class Sample1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()
    }
     private fun inject(){
         val default = DefaultMainConfig(this)
         val tempContext = DefaultTemplateContext(this)
         val config = AppConfiguration.inject?.invoke(default,tempContext)
         config?.let{
             AppConfiguration.username = it.appData.username
             AppConfiguration.password = it.appData.password
             AppConfiguration.customPage = it.mainScreen.pageHost.customPage.view
         }

         AppConfiguration.inject  = null
     }
}
