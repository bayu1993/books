package com.example.bayu.mamikostest.network

import com.example.bayu.mamikostest.data.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("cabaca/_table/genre")
    fun getGenre(): Observable<GenreResponse>

    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/category")
    fun getBookByGenre(@Query("id") genre_id:Int): Observable<BookGenreResponse>

    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/uptodate")
    fun getNewBook(@Query("limit") limit:Int): Observable<BookGenreResponse>

    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/uptodate")
    fun getBooks(): Observable<BookGenreResponse>

    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("book/detail/{book_id}")
    fun getBookDetail(@Path("book_id") bookId:Int): Observable<BookDetailResponse>

    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("writer/popular")
    fun getPenulisPopular(@Query("limit") limit: Int): Observable<PenulisPopularResponse>

    @Headers("x-dreamfactory-api-key:25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb")
    @GET("writer/detail/{user_id}")
    fun getPenulisDetail(@Path("user_id") userId:Int): Observable<PenulisDetailResponse>


}