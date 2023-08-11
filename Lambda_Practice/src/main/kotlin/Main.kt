fun main() {
    var userId = 1
    HttpController.sendGetRequest("https://localhost:8080/api/users/${userId}") { user ->
        println("User name is : ${user.getName()}")
        println("User age is : ${user.getAge()}")
    }
}