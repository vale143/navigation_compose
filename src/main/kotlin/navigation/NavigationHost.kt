package navigation

import androidx.compose.runtime.Composable

class NavigationHost(
    val navController: NavController,
    val contents: @Composable NavigationGraphBuilder.() -> Unit
) {
    @Composable
    fun build(){
        NavigationGraphBuilder().renderContents()
    }
    inner class NavigationGraphBuilder(
        val navigationController: NavController = this@NavigationHost.navController
    ){
        @Composable
        fun renderContents(){
            this@NavigationHost.contents(this)
        }
    }
}

@Composable
fun NavigationHost.NavigationGraphBuilder.composable(
    route: String,
    content: @Composable () -> Unit
){
    if(navigationController.currentScreen.value == route){
        content()
    }
}