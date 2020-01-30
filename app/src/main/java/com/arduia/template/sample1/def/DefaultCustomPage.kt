package com.arduia.template.sample1.def

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.arduia.template.sample1.R
import com.arduia.template.sample1.framework.ui.Page

class DefaultCustomPage(private val ctx:Context):Page{
    override val view: View
        get() = LayoutInflater.from(ctx).inflate(R.layout.custom_fragment,null,false)
}