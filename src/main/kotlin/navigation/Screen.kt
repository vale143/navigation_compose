package navigation

import HomeScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(
    val label: String,
    val icon: ImageVector
) {
    HomeScreen(
        label = "Home",
        icon = Icons.Filled.Home
    ),
    Login(
    label = "Login",
    icon = Icons.Filled.AccountBox
    )
}

@Composable
fun CustomNavigationHost(
    navController: NavController
) {
    NavigationHost(navController) {
        composable(Screen.Login.name){
            Login(navController)
        }
        composable(Screen.HomeScreen.name){
            HomeScreen(navController)
        }
    }.build()
}