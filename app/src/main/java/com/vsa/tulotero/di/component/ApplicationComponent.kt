package com.vsa.tulotero.di.component

import com.vsa.tulotero.di.PerApplication
import com.vsa.tulotero.di.module.ApplicationModule
import com.vsa.tulotero.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
@PerApplication
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun activityComponentBuilder(): ActivityComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun baseUrl(baseUrl: String): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun applicationModule(applicationModule: ApplicationModule): Builder

        fun build(): ApplicationComponent

    }

}