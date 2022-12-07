package com.example.infinitylist.data

const val GOOGLE_API = "https://www.googleapis.com/"

class BookRepository {
    private val bookService = createWebService(GOOGLE_API, BookService::class.java)

    suspend fun getBooks(query: String, page: Int, limit: Int) =
        bookService.getBooks(query, page, limit)
}