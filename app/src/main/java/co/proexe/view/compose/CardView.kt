package co.proexe.view.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ProgressIndicatorDefaults.IndicatorBackgroundOpacity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import co.proexe.model.data.TvProgramme
import coil.annotation.ExperimentalCoilApi
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter

@Composable
fun CardView(data: TvProgramme) {
    Card (elevation = 16.dp, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(1.dp)
        .wrapContentSize(Alignment.TopStart)
        .clickable {

        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            CardPicture(data.imageUrl)
            Column(modifier = Modifier
                .fillMaxWidth()){
                CardText(data.title)
//                LinearProgressIndicator(progress = (data.progressPercent/100).toFloat(),
//                    backgroundColor = Color.DarkGray,
//                    color = Color(0xFF4197CA))
                ProgressBar(data.progressPercent)
//                Spacer(Modifier.height(30.dp))
            }
            ExpandMenu()
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CardPicture(image: String){
    Card(modifier = Modifier.padding(16.dp)) {
        Image(painter = rememberImagePainter(
            data = image,
            imageLoader = LocalImageLoader.current,
            builder = {
                crossfade(true)
            }
        ),
            contentDescription = null,
            modifier  = Modifier
                .height(52.dp)
                .width(52.dp))
    }
}

@Composable
fun CardText(data: String){
    Column(modifier = Modifier
        .fillMaxWidth()) {
        Text(modifier = Modifier
            .height(21.dp)
            .width(0.dp),
            color = Color.White,
            fontFamily = FontFamily.Serif,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = data)
    }
}

@Composable
fun ProgressBar(progress: Int) {
    val context = LocalContext.current.applicationContext
    val screenWidth = context.resources.displayMetrics.widthPixels
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 39.dp, 0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .height(3.dp)
                .background(Color.Gray)
                .width(screenWidth.dp)
                .padding(0.dp, 0.dp, 39.dp, 0.dp),
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .height(3.dp)
                    .background(Color(0xFF4197CA))
                    .width(screenWidth.dp * progress / 100)
                    .padding(0.dp, 0.dp, 39.dp, 0.dp),
            )
        }

    }
}

@Composable
fun ExpandMenu(){
    var expanded by remember {
        mutableStateOf(false)
    }
    // 3 vertical dots icon
    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Open Options"
        )
    }
}