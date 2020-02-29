package ru.romananchugov.filmsmvvm.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.romananchugov.filmsmvvm.data.data_source.FilmsService
import ru.romananchugov.filmsmvvm.data.repository.FilmsListRepositoryImpl
import ru.romananchugov.filmsmvvm.domain.repository.FilmsListRepository

val dataModule = module {
    single { FilmsListRepositoryImpl(get()) as FilmsListRepository }

    single { provideHttpLoggingInterceptor() }

    single { provideOkHttpClient(get()) }

    single { provideRetrofit(get()) }

    single { provideConverterService(get()) }
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

private fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/")
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .build()

private fun provideConverterService(retrofit: Retrofit): FilmsService =
    retrofit.create(FilmsService::class.java)