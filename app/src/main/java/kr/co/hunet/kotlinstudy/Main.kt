import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

fun main() {
    println("Hello World!")

//    // 코틀린 min, max
//    var a = 3
//    var b = 4
//    val max = max(a,b)
//    val min = min(a,b)
//    println("두 수의 최대값: ${max}")
//    println("두 수의 최소값: ${min}")
//
//    // 시스템입력
//    println("좋아하는 숫자를 입력하세요")
//    val reader = Scanner(System.`in`)
//    val inputVal = reader.nextLine()
//
//    println("너가 좋아하는 숫자는 ${inputVal}")
//
//    println("주사위 굴리기 게임, 숫자를 입력하세요")
//    val randomDice = Scanner(System.`in`).nextInt()
//
//    val diceVal = Random.nextInt(1, randomDice)
//
//    println("짜잔! ${diceVal}")

    // 3주차
    // 조건문
//    일반적인 if/else 문을 사용
    val a = 5

    if (a > 4) {
        println("${ a } 는 4보다 커요 ")
    } else {
        println("${ a } 는 4보다 작아요 ")
    }

//    ->> 바로 상수로 값을 받아서 출력 가능

    var result = if (a > 4) {
        "4 보다 크다."
    } else if (a == 5) {
        "5와 같다."
    } else {
        "!!!! 그지 같다."
    }
    println(result)

    var result2 = when {
        a > 4 -> {
            "4보다 크다아"
        }
        a == 5 -> {
            "5와 같다"
        }
        else -> {
            "!!!! 그지 같다."
        }
    }
    println(result2)

    val result3 = if (a > 4) true else false
    println("3항연산자는 이렇게 씁니다. ${result3}")


    // 반복문

    val items = listOf(1,2,3,4,5)

    // for in으로 사용가능
    for (item in items) {
        print(item)
    }
    // forEach로도 사용 가능
    items.forEach { item ->
        print(item)
    }



    // list
    // array

    var array1  = arrayOf(10,20,30,40)

//    array는 같은 자료형을 가진 값을 모아놓기 위한것.
//    초기화시 size가 정해짐.
//
//    리스트는 순서가 있는 엘리먼트를 모아둔 것.
//    동적타입이라 크기가 정해져있지 않음.

    // null safety

    var name: String? = null

    name = "준석"

    var name2: String = ""

    if (name != null) {
        name2 = name
    }

    // 혹은
    name2 = name!! // 강제언래핑, swift는 ! 하나만 쓰는디


    // swift의 guard let 구문을 이렇게 사용 가능.
    // else 가 없는 ?
    name.let { print(it) }



    // 숙제
//    <aside>
//    💡 [점수를 입력받아 평균 구하기]
//
//    조건
//
//    - scanner 로 점수 입력받기
//            - for문 사용
//            - List, Array 중 사용하기
//    </aside>

//
//    println("")
//    println("평균을 구하려고 합니다. 정수를 3번 입력하세요")
//    var averageArray = Array<Int>(size = 3, init = { it + 1 })
//    for (index in 0 .. 3) {
//        val reader = Scanner(System.`in`)
//        averageArray.set(index, reader.nextInt())
//
//        if (index == 2) {
//            val avg = averageArray.average()
//
//            println("응 평균은 ${avg} 야")
//        }
//    }


//    println(sum(10,20))

    input()

}

//https://verbose-walnut-4c1.notion.site/Kotlin-study-abf23240b78440b3ac826cd9d126983b

// 함수
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 한줄함수는 이렇게 사용 가능
fun sum2(a: Int, b: Int) = a + b

fun sum3(a: Int, b: Int, c: Int = 0) = a + b + c

// 클래스

// 기본 생성자를 바로 받을 수 있음.
data class Person1(
    val name: String, // 기본적으로는 public, private로 설정 가아능
    var age: Int
) {

    /// setter/getter
    var hobby: String? = null
        private set             // setter 속성을 프라이빗으로 변경
        get() = "취미는: $field"   // getter 재정의


    // init 함수 정의
    init {
        println("init....")
    }

    fun some() {
        this.hobby = "야구"
    }
}

// 상속

abstract class Animal {
    open fun bark() {
        println("소리: ")
    }
}

class Dog: Animal(), Runnable {
    override fun bark() {
        super.bark()
        println("멍멍")
    }

    override fun run() {
        println("${"bark()"} 달려갑니다.")
    }
}


class Cat: Animal(), Runnable {
    override fun bark() {
        super.bark()
        println("냥냥")
    }
    override fun run() {
        println("꽁꽁 얼은 한강 위로 고양이가 걸어다닙니다.")
    }
}

// interface
interface Runnable {
    fun run()
}



/*
<aside>
💡 학생 정보를 한번에 입력받아 자기소개하는 함수 만들기

1. 한번에 입력받을 정보 : 이름, 나이, 전공
2. Class  2개이상 만들기,
3. 상속 이용하기
</aside>

 */



fun input() {
    println("이름, 나이, 전공을 한번에 입력하세요 (띄어쓰기로 구분)")

    var data : MutableList<Student> = mutableListOf<Student>()

    val read = readLine() ?: ""

    val details = read.split(" ")

    val name = details.getOrNull(0) ?: "이름 없음"
    val age = details.getOrNull(1) ?: "-1"
    val major = details.getOrNull(2) ?: "전공 없음"

    val student = Student(major)
    student.name = name
    student.age = age.toInt()

    println("안녕~ 내 이름은 ${student.name}")
    println("올해 ${student.age}살 이야.")
    println("대학에서 ${student.major}를 전공하고 있다구!")

}

data class Student  (
    var major: String
) : Person() {

}

abstract class Person {
    open lateinit var name: String
    open var age: Int = 0
}




