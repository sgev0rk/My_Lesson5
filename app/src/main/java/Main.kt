val allFoundMembers: HashSet<Person> = hashSetOf()

fun main() {
    val person1 = Person("Gevorg", 92, father = null, mother = null)
    val person2 = Person("Mariam", 85, father = null, mother = null)
    val person3 = Person("Vova", 91, father = null, mother = null)
    val person4 = Person("Nastya", 81, father = null, mother = null)
    val person5 = Person("Vladimir", 95, father = null, mother = null)
    val person6 = Person("Kostya", 52, father = person1, mother = person2)
    val person7 = Person("Olya", 56, father = person3, mother = person4)
    val person8 = Person("Alex", 54, father = person3, mother = person4)
    val person9 = Person("Simba", 58, father = null, mother = person5)
    val person10 = Person("Kostya", 54, father = null, mother = person5)
    val person11 = Person("Ora", 17, father = person6, mother = person7)
    val person12 = Person("Valya", 24, father = person6, mother = person7)
    val person13 = Person("Lenya", 17, father = person8, mother = person9)
    val person14 = Person("Kisa", 24, father = person8, mother = person9)
    val me = Person("Gevork", 35, father = null, mother = person9)

    me.allRelatives()
    me.getMe()
    println("\nNumber of relatives: ${allFoundMembers.count()} ")
}