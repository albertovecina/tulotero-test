package com.vsa.tulotero.di.module

import com.vsa.tulotero.data.source.network.ApiInterface
import com.vsa.tulotero.di.PerApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
@Module
class NetworkModule() {

    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun providesRetrofit(baseUrl: String, gsonConverterFactory: GsonConverterFactory) =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()

    @PerApplication
    @Provides
    fun providesApiInterface(retrofit: Retrofit) = retrofit.create(ApiInterface::class.java)

}