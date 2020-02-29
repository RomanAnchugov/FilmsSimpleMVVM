package ru.romananchugov.filmsmvvm.data.data_source

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.romananchugov.filmsmvvm.data.model.FilmsNWResponse

interface FilmsService {
    @GET("3/movie/popular?api_key=befc7872520fd736c58948abb2f4a53c")
    fun getFilmsList(): Single<FilmsNWResponse>
}