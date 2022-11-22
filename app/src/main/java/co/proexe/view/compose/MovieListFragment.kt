package co.proexe.view.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import co.proexe.model.data.TvProgramme

@Composable
fun MovieListFragment(data: List<TvProgramme> ) {
    Scaffold(backgroundColor = Color(0x000000000)) {
        Column(modifier = Modifier
            .fillMaxWidth()) {
            LazyColumn {
                items(data.size){ index ->
                    CardView(data = data[index])
                }
            }
        }
    }
}