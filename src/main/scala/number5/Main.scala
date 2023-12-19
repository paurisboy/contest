package number5
import java.util.Scanner
import scala.collection.mutable.ArrayBuffer
object Main {
  val in = new Scanner(System.in)
  case class Children(var count: Int, friends: ArrayBuffer[Int])
  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val m = in.nextInt()
    val q = in.nextInt()
    val array = new Array[Children](n+1)
    var i = 1
    while (i <= n) {
      array(i) = Children(in.nextInt(), new ArrayBuffer[Int])
      i+=1
    }
    i = 0
    while (i < m) {
      val first = in.nextInt()
      val second = in.nextInt()
      array(first).friends += second
      array(second).friends += first
      i+=1
    }
    i = 0
    while (i < q) {
      val sym = in.next()
      if (sym == "?") println(question(array))
      else if (sym == "+") plus(array)
      i+=1
    }
  }
  def question(array: Array[Children]): Int = {
    val v = in.nextInt()
    array(v).count
  }

  def plus(array: Array[Children]): Unit = {
    val v = in.nextInt()
    val x = in.nextInt()
    array(v).friends.foreach(i => array(i).count+=x)
  }
}
