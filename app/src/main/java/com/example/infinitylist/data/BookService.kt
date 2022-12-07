package com.example.infinitylist.data

import com.example.infinitylist.data.model.Books
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("books/v1/volumes")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("startIndex") page: Int,
        @Query("maxResults") limit: Int
    ): Books

}