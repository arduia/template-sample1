package com.arduia.template.sample1.framework

import com.arduia.template.sample1.MainConfig

interface Template{
    fun inject(config: MainConfig):MainConfig
}