import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
){
    val user = User(
        username = "Jose",
        password = "password",
        userType = UserType.ADMIN,
        permission = listOf(
            Permissions.REGISTER_USER,
            Permissions.LOGIN
        )
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(navController.currentScreen.value)
    }
}

fun registerUser(user: User){
    if(user.userType == UserType.ADMIN || user.permission.contains(Permissions.REGISTER_USER)){
        //puede register
    }
}

data class User(
    val username: String,
    val password:String,
    val userType: UserType,
    val permission: List<Permissions>
)

enum class UserType{
    ADMIN, GENERAL
}

enum class Permissions {
    REGISTER_USER, LOGIN, EDIT, DELETE
}