package com.kotlin.exercise.chapter5

import android.view.View
import android.widget.Toast
import java.io.File

//集合的函数式API
//filter map filterValues mapValues
fun main() {
    //filter函数可以从集合中移除不想要的函数，但它并不会改变这些元素
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })

    val people = listOf(Person("Alice", 27), Person("Bob", 31), Person("Charles",27), Person("Dan",21))
    println(people.filter { it.age > 30 })

    //map元素的变换
    println(list.map { it * it })
    println(people.map { it.name })
    println(people.map(Person::name))

    println(people.filter { it.age > 30 }.map(Person::name))

    //找到分组中所有年龄最大的人的名字
    people.filter { it.age == people.maxBy(Person::age)?.age }

    //优化
    val maxAge = people.maxBy(Person::age)?.age
    people.filter { it.age == maxAge }

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    val canBeInClub27 = { p: Person -> p.age <= 27 }

    //判断所有元素都满足用 all
    println(people.all(canBeInClub27))
    //检查至少有一个匹配元素用 any
    println(people.any(canBeInClub27))

    //!all !any最好不用 用any all替代
    println(!list.all { it == 3 }) //!否定不明显
    println(list.any { it == 3 }) //用如下替代

    //判断有多少个元素满足条件使用 count
    println(people.count(canBeInClub27))
    println(people.filter(canBeInClub27).size)

    //找到满足条件的元素用 find
    println(people.find(canBeInClub27))

    //如果有多个拼配返回第一个元素或者返回null 用 firstOrNull
    println(people.firstOrNull(canBeInClub27))

    //把所有元素按照不同的特征划分成不同的分组 用 groupBy
    println(people.groupBy { it.age })

    //按照首字母分组
    val list1 = listOf("a","ab","b")
    println(list1.groupBy (String::first))

    //flatMap 1、根据作为实参给定的函数对集合中的每个元素做变换 2、把多个列表合成一个列表
    //如果只是平铺一个集合不需要做变换可以使用flatten
    val strings = listOf("abc","def")
    //toList函数把字符串转换成字符列表
    println(strings.flatMap { it.toList() })

    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
                       Book("Mort",listOf("Terry Pratchett")),
                       Book("Good Omens", listOf("Terry Pratchett","Neil Gaiman")))

    //book.authors存储了每个书籍的作者集合，flatMap把所有书籍的作者合并成一个扁平的列表，toSet调用移除了结果集合中的所有重复元素
    println(books.flatMap { it.authors }.toSet())

    //惰性集合操作：序列
    people.map(Person::name).filter { it.startsWith("A") }
    //filter和map都会返回一个列表，这意味上述链式调用会创建两个列表；一个保存filter函数的结果一个保存map函数的结果，如果有上百万个数据就非常低效
    //为了提高效率把操作变成使用序列，而不是直接使用集合
    people.asSequence()
            .map(Person::name)
            .filter { it.startsWith("A") }
            .toList()
    //Kotlin惰性集合操作的入口就是Sequence接口，这个接口表示的就是一个可以逐个列举的元素序列，Sequence只提供了一个方法，iterator，用来从序列中获取值
    //Sequence接口的强大之处在于其操作的方式实现。序列中的元素求值是惰性的。因此，可以使用序列更高效地对集合元素执行链式操作，而不需要额外的集合保存结果

    //序列操作分为两类：中间的和末端的 一次中间操作返回的是另一个序列，一次末端操作返回的是一个结果
    //中间操作始终是惰性的,缺少末端操作并不会在控制台输出任何内容
    listOf(1,2,3,4).asSequence()
            .map { print("map($it)");it*it }
            .filter { print("filter($it)");it%2 == 0 }

    //末端操作触发所有的延期计算
    listOf(1,2,3,4).asSequence()
            .map { print("map($it)");it*it }
            .filter { print("filter($it)");it%2 == 0 }
            .toList()

    println(listOf(1,2,3,4).asSequence().map { it*it }.find { it>3 })

    println(people.asSequence().map(Person::name).filter { it.length<4 }.toList())

    //创建序列 generateSequence
    //naturalNumbers和numbersTo100都是有延期操作的序列，直到调用末端操作（sum）的时候才会求值
    val naturalNumbers = generateSequence(0) {  it + 1}
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    //创建并使用父目录的序列
    fun File.isInsideHiddenDirectory() = generateSequence(this){it.parentFile}.any { it.isHidden }

    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())

    //SAM构造方法(带单抽象方法的接口叫SAM接口)
    fun createAllDoneRunnable():Runnable{
        return Runnable { println("All done!") }
    }
    createAllDoneRunnable().run()

    //使用SAM构造来重用listener实例
//    val listener = View.OnClickListener{view ->
//        val text = when(view.id){
//            R.id.button1 -> "First button"
//            R.id.button2 -> "Second button"
//            else -> "Unknown button"
//        }
//        toast(text)
//    }
//
//    button1.setOnClickListener(listener)
//    button2.setOnClickListener(listener)

}

class Book(val title:String,val authors:List<String>)

