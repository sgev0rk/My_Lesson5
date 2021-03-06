class Person(
    val name: String,
    val age: Int,
    val isAdult: Boolean = age >= 18,
    var father: Person? = null,
    var mother: Person? = null,
    var children: List<Person> = listOf<Person>(),
    var checkedPerson: Boolean = false
) {
    init{
        if (this.father != null && this.mother == null){
            this.father!!.children = this.father!!.children.plus(this)
        } else if (this.father == null && this.mother != null){
            this.mother!!.children = this.mother!!.children.plus(this)
        } else if (this.father != null && this.mother != null){
            this.mother!!.children = this.mother!!.children.plus(this)
            this.father!!.children = this.father!!.children.plus(this)}
    }

    fun allRelatives(): HashSet<Person> {
        var newMembers: HashSet<Person> = hashSetOf()
        if (checkedPerson) {
            return newMembers
        }

        children?.forEach { element ->
            newMembers.add(element)
            allFoundMembers.add(element)
        }
        father?.let {
            newMembers.add(it)
            allFoundMembers.add(it)
        }
        mother?.let {
            newMembers.add(it)
            allFoundMembers.add(it)
        }

        checkedPerson = true

        newMembers.add(this)

        newMembers.forEach {
            if (it.checkedPerson == false) {
                allFoundMembers.add(it)
                it.allRelatives()
            }
        }

        return newMembers
    }

    fun getMe() {
        allFoundMembers.forEach {
            println("Name: ${it.name}, Age: ${it.age}, isAdult: ${it.isAdult}")
        }
    }
}

