package number3
import java.util.Scanner
object Main {
  val in = new Scanner(System.in)
  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val m = in.nextInt()
    val presentsList = new Array[Int](n)
    for(i <- 0 until n)
      presentsList(i) = in.nextInt()
    var left = 1
    var right = m
    var max = 0
    while (left < right) {
      var balance1 = left
      var balance2 = right
      for(i <- 0 until n) {
        if(balance1 >= presentsList(i)) balance1 -= presentsList(i)
        if(balance2 >= presentsList(i)) balance2 -= presentsList(i)
      }
      if(balance2 >= balance1 && balance2 > max) max = balance2
      else if(balance1 > balance2 && balance1 > max) max = balance1
      left += 1
      right -= 1
    }
    println(max)
  }
}
