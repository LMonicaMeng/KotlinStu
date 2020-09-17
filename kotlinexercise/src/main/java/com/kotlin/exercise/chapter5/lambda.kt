package com.kotlin.exercise.chapter5

import android.widget.Button

//lambda表达式语法
//{x:Int,y:Int -> x + y}
// 参数            函数体
fun main(){
    val people = listOf(Person("Alice",29), Person("Bob",31))
    findTheOldest(people)

    //用lambda在集合中搜索 maxBy函数可以在任何集合上调用，且只需要一个实参，指定比较哪个值来找到最大元素
    people.maxBy { p:Person -> p.age }
    people.maxBy { p -> p.age }
    println(people.maxBy { it.age })
    people.maxBy ( Person::age )


    val sum = {x:Int,y:Int -> x+y}
    println(sum(1,2))

    //确定需要把一小段代码封闭在一个代码块中，可以使用库函数run来执行传给它的lambda
    run { println(42) }

    val errors = listOf("403 Forbidden","404 Not Found")
    printMessageWithPrefix(errors,"Error:")

    val responses = listOf("200 Ok","418 I'm a teapot","500 Internal Server Error")
    printProblemCounts(responses)

    //引用顶层函数
    run(::salute)

    val createPerson = ::Person
    val p = createPerson("Alice",29)
    println(p)

    //引用扩展函数
    val predicate =Person::isAdult

    val p1 = Person("Dmitry",34)
    val personsAgeFunction = Person::age
    //personsAgeFunction是一个但参数函数
    println(personsAgeFunction(p1))

    val dmitrysAgeFunction = p1::age
    //dmitrysAgeFunction是一个零参数函数
    println(dmitrysAgeFunction())
}

data class Person(val name:String,val age:Int)

fun findTheOldest(people:List<Person>){
    var maxAge = 0
    var theOldest:Person? = null
    for (person in people){
        if(person.age > maxAge){
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

//在lambda中使用函数参数
fun printMessageWithPrefix(messages:Collection<String>,prefix:String){
    messages.forEach{
        println("$prefix $it")
    }
}

//在lambda中改变局部变量
fun printProblemCounts(responses:Collection<String>){
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if(it.startsWith("4")){
            clientErrors++
        }else if (it.startsWith("5")){
            serverErrors++
        }
    }
    println("$clientErrors client errors,$serverErrors server errors")
}

//记录按钮点击次数的错误实现，始终返回为0  onClick处理器是在函数返回之后调用的，应该把点击次数存储在函数外
//fun tryToCountButtonClicks(button: Button):Int{
//    var clicks = 0
//    button.onClick{clicks ++}
//    return clicks
//}

//成员引用 使用：：把函数转换成一个值
val getAge = Person::age

fun salute() = println("Salute!")

fun sendEmail(person:Person,message:String){
    println(message)}

val action = {person:Person,message:String -> sendEmail(person,message)}
val nextAction = ::sendEmail

fun Person.isAdult() = age >= 21




