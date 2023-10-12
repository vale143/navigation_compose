import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.CustomNavigationHost
import navigation.Screen
import navigation.rememberNavController

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val screens = Screen.values().toList()
    val navController by rememberNavController(Screen.Login.name)
    val currentScreen by remember {
        navController.currentScreen
    }

    MaterialTheme {
        Surface(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                if (navController.currentScreen.value != Screen.Login.name) {
                    Box(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back button",
                            modifier = Modifier.clickable {
                                navController.navigateBack()
                            }
                        )

                    }
                }
                Box(modifier = Modifier.fillMaxHeight()) {
                    CustomNavigationHost(navController = navController)
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
