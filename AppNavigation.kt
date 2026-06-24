package navigation

sealed class Screen {
    object Login : Screen()
    object Dashboard : Screen()
    object Register : Screen()
}