package com.example.infinitylist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.infinitylist.data.BookRepository
import com.example.infinitylist.data.BookPagingSource


private const val PAGE_SIZE = 10

class MainViewModel : ViewModel() {

    var query = mutableStateOf("")
        private set

    private val repo: BookRepository = BookRepository()
    private lateinit var pagingSource : BookPagingSource

    val bookPager = Pager(PagingConfig(pageSize = PAGE_SIZE)) {
        BookPagingSource(query.value, repo).also { pagingSource = it }
    }.flow

    fun setQuery(query: String) {
        this.query.value = query
    }

    fun invalidateDataSource() {
        pagingSource.invalidate()
    }
}