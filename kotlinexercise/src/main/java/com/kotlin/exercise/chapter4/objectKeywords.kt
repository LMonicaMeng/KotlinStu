package com.kotlin.exercise.chapter4

import java.io.File

//"object"关键字：将声明一个类与创建一个示例结合

fun main(){
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/User")))

    val files = listOf(File("/z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}

object Payroll{
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary(){
        for (person in allEmployees){
            /*...*/
        }
    }
}

object CaseInsensitiveFileComparator:Comparator<File>{
    override fun compare(file1: File?, file2: File?): Int {
        return file1!!.path.compareTo(file2!!.path,ignoreCase = true)
    }
}

data class Person(val name:String){
   object NameComparator:Comparator<Person>{
       override fun compare(p0: Person, p1: Person): Int =
           p0.name.compareTo(p1.name)
   }
}