package number1

import java.util.Scanner

object Main {
  val in = new Scanner(System.in)

  def main(args: Array[String]): Unit = {
    val t = in.nextInt()
    var i = 0
    val refStr = "TINKOFF".sorted
    val answers = new Array[String](t)
    while(i < t) {
      val str = in.next()
      answers(i) =
        if(str.sorted == refStr) "Yes"
        else "No"
      i+=1
    }
    answers.foreach(ans => println(ans))
  }
}
