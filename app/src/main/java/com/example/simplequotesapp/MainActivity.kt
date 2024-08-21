import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.simplequotesapp.DataManager
import com.example.simplequotesapp.screens.QuoteDetail
import com.example.simplequotesapp.screens.QuoteListScreen
import com.example.simplequotesapp.ui.theme.SimpleQuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            SimpleQuotesAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPage(it)
            }
        } else {
            DataManager.currentQuotes?.let {
                QuoteDetail(quotes = it)
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading......", style = MaterialTheme.typography.h6)
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}
