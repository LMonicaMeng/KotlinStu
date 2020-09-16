package com.kotlin.exercise.chapter4

//数据类和类委托
fun main(){
    val client = Client("Alice",342652)
    println(client)

    // Kotlin中==检查对象是否相等而不是比较引用，这里会编译成调用"equals"
    val client1 = Client("Alice",342562)
    val client2 = Client("Alice",342562)
    println(client1 == client2)

    val processed = hashSetOf(Client("Alice",342562))
    println(processed.contains(Client("Alice",342562)))

    val bob = Client("Bob",973293)
    println(bob.copy(postalCode = 382555))

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,1,2))
    println("${cset.objectsAdded} objects were added,${cset.size} remain")
}
class Client(val name:String,val postalCode:Int){
    override fun toString(): String = "Client(name = $name,postalCode = $postalCode)"

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode()*31+postalCode

    fun copy(name: String = this.name,postalCode: Int = this.postalCode) = Client(name, postalCode)
}

class DelegatingCollection<T> : Collection<T>{
    private val innerList = arrayListOf<T>()
    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean = innerList.isEmpty()

    override fun containsAll(elements: Collection<T>): Boolean =innerList.containsAll(elements)

    override fun isEmpty(): Boolean = innerList.isEmpty()

    override fun iterator(): Iterator<T> = innerList.iterator()

}

//by关键字将接口的实现委托到另一个对象，实现与上述相似
class DelegatingCollection1<T>(innerList:Collection<T> = ArrayList<T>()):Collection<T> by innerList{}

//将MutableCollection的实现委托给innerSet
class CountingSet<T>(val innerSet:MutableCollection<T> = HashSet<T>()):MutableCollection<T> by innerSet{
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}