package com.example.infinitylist.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.infinitylist.data.model.Book
import com.example.infinitylist.nextKey
import com.example.infinitylist.prevKey

class BookPagingSource(
    private val query: String,
    private val repo: BookRepository
) : PagingSource<Int, Book>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> {
        return try {
            if (query.isEmpty()) return LoadResult.Page(data = emptyList(), null, null)
            val nextPageNumber = params.key ?: 1
            val response = repo.getBooks(query, nextPageNumber, params.loadSize)

            LoadResult.Page(
                data = response.items,
                prevKey = params.prevKey(),
                nextKey = params.nextKey(response.totalItems)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Book>): Int =
        ((state.anchorPosition ?: 0) - state.config.initialLoadSize / 2)
            .coerceAtLeast(0)

}
