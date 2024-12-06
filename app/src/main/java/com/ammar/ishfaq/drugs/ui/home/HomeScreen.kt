import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ammar.ishfaq.drugs.R
import com.ammar.ishfaq.drugs.models.drugs.Drugs
import com.ammar.ishfaq.drugs.ui.components.AppLoader
import com.ammar.ishfaq.drugs.ui.components.ErrorItem
import com.ammar.ishfaq.drugs.ui.home.GreetingScreen
import com.ammar.ishfaq.drugs.ui.home.HomeScreenContent
import com.ammar.ishfaq.drugs.ui.home.HomeScreenUiState

@Composable
fun HomeScreen(
    userName: String,
    uiState: HomeScreenUiState,
    loadData: (Boolean) -> Unit,
    onRefresh: () -> Unit,
) {

    LaunchedEffect(Unit) {
        loadData(false)
    }

    Scaffold(
        topBar = {
            EnhancedTopAppBar(onRefresh)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            GreetingScreen(username = userName)

            Box {
                when (uiState) {

                    is HomeScreenUiState.Loading -> {
                        AppLoader(modifier = Modifier.fillMaxSize())
                    }

                    is HomeScreenUiState.Success -> {
                        HomeScreenContent(
                            modifier = Modifier.fillMaxSize(),
                            msg = uiState.obj,
                        )
                    }

                    is HomeScreenUiState.Error -> {
                        ErrorItem(
                            text = uiState.msg,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    HomeScreenUiState.Initial -> {}

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnhancedTopAppBar(
    onRefresh: () -> Unit,

    ) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(
                modifier = Modifier.testTag("refresh"),
                onClick = { onRefresh.invoke() }) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Refresh",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier.shadow(4.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        "ammarishfaq25@gmail.com",
        loadData = {},
        uiState = HomeScreenUiState.Success(
            obj = Drugs(
                problems = emptyList()
            )
        ),
    ) {

    }
}
