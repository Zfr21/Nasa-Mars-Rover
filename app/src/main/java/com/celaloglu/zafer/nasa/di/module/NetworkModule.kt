package com.celaloglu.zafer.nasa.di.module

import com.celaloglu.zafer.nasa.BuildConfig
import com.celaloglu.zafer.nasa.api.service.NasaService
import com.celaloglu.zafer.nasa.di.scopes.PerApplication
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    @PerApplication
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(createAuthenticationInterceptor())
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @PerApplication
    internal fun provideNasaService(okHttpClient: OkHttpClient): NasaService {
        val httpClientBuilder = okHttpClient.newBuilder()
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClientBuilder.build())
                .build()
        return retrofit.create(NasaService::class.java)
    }

    private fun createAuthenticationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build()

            val requestBuilder = original.newBuilder()
                    .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }
}