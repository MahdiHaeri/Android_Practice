class User(private var name: String, private var age: Int) {
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAge(): Int {
        return age
    }

    fun setAge(age: Int) {
        this.age = age
    }

    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }
}