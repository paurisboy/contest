package number2

import java.util.Scanner

object Main {
  val in = new Scanner(System.in)

  def main(args: Array[String]): Unit = {
    val t = in.nextInt()
    val answers = new Array[String](t)
    for(i <- 0 until t) {
      val n = in.nextInt()
      var sum = 1
      for(j <- 0 until n)
        sum += in.nextInt() - 1
      answers(i) =
        if(sum >= n - 1) "Yes"
        else "No"
    }
    answers.foreach(ans => println(ans))
  }
}
