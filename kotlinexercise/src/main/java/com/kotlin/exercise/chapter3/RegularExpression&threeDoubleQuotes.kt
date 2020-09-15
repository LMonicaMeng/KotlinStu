package com.kotlin.exercise.chapter3

//正则表达式和三重引号

//目录（最后一个/前） 文件名 .前 扩展名 .后
val pathString = "/Users/yole/kotlin-book/chapter.adoc"

fun main(){
    parsePath(pathString)
    parsePath1(pathString)

    //trimMargin用来删除每行的前缀和前面的空格（例子中用.表示前缀）
    val kotlinLogo = """| //
                        .|//
                        .|/ \
                        """.trimMargin(".")

    println(kotlinLogo)
}

fun parsePath(path:String){
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir:$directory,name:$fileName,ext:$extension")
}

//使用正则表达式解析文件路径
//三重引号表示的字符串内无需对任何字符进行转义
fun parsePath1(path: String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult!=null){
        val(directory,filename,extension) = matchResult.destructured
        println("Dir:$directory,name:$filename,ext:$extension")
    }
}
