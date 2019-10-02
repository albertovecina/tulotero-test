package com.vsa.tulotero.di.component

import android.content.Context
import com.vsa.tulotero.di.PerActivity
import com.vsa.tulotero.di.module.ActivityModule
import com.vsa.tulotero.view.main.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context):Builder

        fun activityModule(activityModule: ActivityModule): Builder

        fun build(): ActivityComponent

    }

}