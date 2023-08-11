object HttpController {

    fun sendGetRequest(url: String, complition: (User) -> Unit) {
        // some code
        var user = User("John", 25)
        complition(user)
    }
}