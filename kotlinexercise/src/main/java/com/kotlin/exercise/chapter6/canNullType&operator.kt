package com.kotlin.exercise.chapter6

import java.lang.IllegalArgumentException


fun main(){
    printAllCaps("abc")
    printAllCaps(null)
    printAllCaps("")

    val ceo = Employee("Da Boss",null)
    val developer = Employee("Bob Smith",ceo)
    println(managerName(developer))
    println(managerName(ceo))

    val person = Person("Dmitry",null)
    println(person.countryName())

    println(strLenSafe("abc"))
    println(strLenSafe(null))

    val address = Address("Elsestr. 47",80687,"Munich","Germany")
    val jetbrains = Company("JetBrains",address)
    val person1 = Person("Dmitry",jetbrains)
    printShippingLabel(person1)
//    printShippingLabel(Person("Alexey",null))

    val p1 = Person1("Dmitry","Jemerov")
    val p2 = Person1("Dmitry","Jemerov")
    println(p1 == p2)
    println(p1.equals(42))

//    ignoreNulls(null)

    var email:String? = "yole@example.com"
    email?.let { sendEmailTo(it) }

    email = null
    email?.let { sendEmailTo(it) }

    verifyUserInput(" ")
    verifyUserInput(null)
}
//可空类型?.
fun printAllCaps(s:String?){
    val allCaps:String? = s?.toUpperCase()
    println(allCaps)
}

//使用安全调用处理可空属性
class Employee(val name:String,val manager:Employee?)

fun managerName(employee: Employee):String? = employee.manager?.name

//链接多个安全调用
class Address(val streetAdress:String,val zipCode:Int,val city:String,val country:String)
class Company(val name: String,val address: Address?)
class Person(val name: String,val company: Company?)

fun Person.countryName():String{
    val country = this.company?.address?.country
    return if(country != null) country else "UnKnow"
}

//Elvis运算符 ?:
fun strLenSafe(s:String?):Int = s?.length ?: 0

//上面代码优化
fun Person.countryName1():String = company?.address?.country ?: "Unknown"

//return和throw这样的操作其实是表达式，可以把它们写在Elvis运算符的右边
fun printShippingLabel(person:Person){
    val address = person.company?.address
            ?:throw IllegalArgumentException("No address")
    with(address){
        println(streetAdress)
        println("$zipCode $city,$country")
    }
}

//安全转换 as?
class Person1(val firstName:String,val lastName:String){
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person1 ?: return false
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
            firstName.hashCode() * 37 + lastName.hashCode()
}

//非空断言 !! 如果使用非空断言值为null，可以显示的抛出异常 避免在同一行中使用多个!!异常时不容易定位错误
fun ignoreNulls(s:String?){
    val sNotNull:String = s!!
    println(sNotNull.length)
}

//let让处理可空表达式变得容易
fun sendEmailTo(email:String){
    println("Sending email to $email")
}

class MyService{
    fun performAction():String = "foo"
}

//class MyTest{
//    private var myService:MyService? = null
//
//    @Before fun setUp(){
//        myService = MyService()
//    }
//
//    //此处必须注意可空性 用!!或者?.
//    @Test fun testAction(){
//        Assert.assertEquals("foo",myService!!.performAction())
//    }
//}

//增加lateinit修改以上代码
//class MyTest1{
//    private lateinit var myService:MyService
//
//    @Before fun setUp(){
//        myService = MyService()
//    }
//
//    //增加lateinit此处可以不必判空
//    @Test fun testAction(){
//        Assert.assertEquals("foo",myService.performAction())
//    }
//}

fun verifyUserInput(input:String?){
    if(input.isNullOrBlank()){
        println("Please fill in the required fields")
    }
}



