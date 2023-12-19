package number6
import java.util.Scanner
object Main {
  val in = new Scanner(System.in)
  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val q = in.nextInt()
    val array = new Array[Int](n+1)
    for(i <- 1 to n) array(i) = in.nextInt()
    var k = 0
    while(k < q) {
      val sym = in.next()
      if(sym == "?") println(question(array))
      else if(sym == "+") plus(array)
      k+=1
    }
  }
  def plus(array: Array[Int]): Unit = {
    val l = in.nextInt()
    val r = in.nextInt()
    val x = in.nextInt()
    for(i <- l to r) {
      array(i) += x
    }
  }
  def question(array: Array[Int]): Int = {
    val l = in.nextInt()
    val r = in.nextInt()
    val k = in.nextInt()
    val b = in.nextInt()
    var max = array(l)
    for(i <- l to r) {
      val temp = k*i+b
      val min =
        if(array(i) > temp) temp
        else array(i)
      if(min > max) max = min
    }
    max
  }
}
