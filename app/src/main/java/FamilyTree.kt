val allFoundMembers: HashSet<Person> = hashSetOf()

class Person(
    val name: String,
    val age: Int,
    val isAdult: Boolean = age >= 18,
    val father: Person? = null,
    val mother: Person? = null,
    var children: List<Person>? = listOf(),
    var checkedPerson: Boolean = false
) {
    fun allRelatives(): HashSet<Person> {
        var newMembers: HashSet<Person> = hashSetOf()
        if (checkedPerson) {
            return newMembers
        }

        newMembers.add(this)

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

fun main() {
    val person1 = Person("Gevorg", 92)
    val person2 = Person("Mariam", 85)
    val person3 = Person("Vova", 91)
    val person4 = Person("Nastya", 81)
    val person5 = Person("Vladimir", 95)
    val person6 = Person("Kostya", 52, father = person1, mother = person2)
    val person7 = Person("Olya", 56, father = person1, mother = person2)
    val person8 = Person("Alex", 54, father = person3, mother = person4)
    val person9 = Person("Simba", 58, father = person3, mother = person5)
    val person10 = Person("Kostya", 54, father = person5)
    val person11 = Person("Ora", 17, father = person6, mother = person7)
    val person12 = Person("Valya", 24, father = person6, mother = person7)
    val person13 = Person("Lenya", 17, father = person8, mother = person9)
    val person14 = Person("Kisa", 24, father = person8, mother = person9)
    val me = Person("Gevork", 35, father = person8, mother = person9)

    person1.children = listOf<Person>(person6)
    person2.children = listOf<Person>(person6)
    person3.children = listOf<Person>(person7, person8, person9)
    person4.children = listOf<Person>(person7, person8)
    person5.children = listOf<Person>(person9, person10)
    person6.children = listOf<Person>(person11, person12)
    person7.children = listOf<Person>(person11, person12)
    person8.children = listOf<Person>(person13, person14, me)
    person9.children = listOf<Person>(person13, person14, me)
    person10.children = listOf<Person>()
    person11.children = listOf<Person>()
    person12.children = listOf<Person>()
    person13.children = listOf<Person>()
    person14.children = listOf<Person>()
    me.children = listOf<Person>()
    me.allRelatives()
    me.getMe()
    println("\nNumber of relatives: ${allFoundMembers.count()} ")
}
