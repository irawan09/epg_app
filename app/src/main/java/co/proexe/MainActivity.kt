package co.proexe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import co.proexe.model.data.TvProgramme
import co.proexe.model.data.utils.Utils
import co.proexe.view.compose.MovieListFragment
import co.proexe.view.theme.EpgAppTheme
import co.proexe.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val dataViewModel : DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.Utils.setLifeCycleOwner(this)

        val observerData = dataViewModel.getRemoteResponseLiveData()
        observerData?.observe(this) { data ->
            mainLayout(data)
        }
    }

    private fun mainLayout(data: List<TvProgramme>){
        setContent {
            EpgAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    MovieListFragment(data)
                }
            }
        }
    }
}