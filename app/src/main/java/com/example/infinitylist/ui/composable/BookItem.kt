package com.example.infinitylist.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage
import com.example.infinitylist.data.model.Book
import com.example.infinitylist.data.model.SearchInfo
import com.example.infinitylist.data.model.VolumeInfo
import com.example.infinitylist.toAnnotatedString
import com.example.infinitylist.ui.theme.Typography

@Composable
fun BookItem(
    book: Book,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.Top) {
        val thumbnail = book.volumeInfo?.imageLinks?.thumbnail?.replaceFirst("http:", "https:")
        Column(
            Modifier
                .fillMaxHeight()
                .weight(0.2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            AsyncImage(
                model = thumbnail,
                contentDescription = book.volumeInfo?.title,
                modifier = Modifier
            )
        }
        Column(
            Modifier
                .fillMaxHeight()
                .weight(0.8f)
                .padding(start = 10.dp,end =10.dp)
        ) {
            Text(
                text = book.volumeInfo?.title.orEmpty(),
                style = Typography.h3
            )
            Text(
                text = HtmlCompat.fromHtml(
                    book.searchInfo?.textSnippet.orEmpty(),
                    HtmlCompat.FROM_HTML_MODE_COMPACT
                ).toAnnotatedString(),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookItemPreview() {
    BookItem(
        book =
        Book(volumeInfo = VolumeInfo("Title"), searchInfo = SearchInfo("Description")),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    )
}