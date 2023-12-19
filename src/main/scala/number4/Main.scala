package number4

import java.util.Scanner
import scala.collection.mutable

case class Node(parent: Int, cost: Int, company: String)

object Main {
  val in = new Scanner(System.in)

  def main(args: Array[String]): Unit = {
    val n = in.nextInt()
    val k = in.nextInt()
    val companies = (0 until k).map(_ => in.next()).toSet
    val nodes = new Array[Node](n + 1)

    var i = 1
    while (i <= n) {
      val parent = in.nextInt()
      val cost = in.nextInt()
      val company = in.next()
      nodes(i) = Node(parent, cost, company)
      i += 1
    }

    val dist: Array[Int] = Array.fill(n + 1)(Int.MaxValue)
    dist(0) = 0

    val queue: mutable.PriorityQueue[Int] = mutable.PriorityQueue(0)(Ordering.by(i => dist(i)))

    while (queue.nonEmpty) {
      val v: Int = queue.dequeue()
      for (u <- 1 to n) {
        if (nodes(u).parent == v && dist(u) > dist(v) + nodes(u).cost) {
          dist(u) = dist(v) + nodes(u).cost
          queue.enqueue(u)
        }
      }
    }

    var totalCost: Int = 0
    for (company <- companies) {
      var minCost: Int = Int.MaxValue
      for (i <- 1 to n) {
        if (nodes(i).company == company) {
          minCost = Math.min(minCost, dist(i))
        }
      }
      if (minCost == Int.MaxValue) {
        println(-1)
        return
      }
      totalCost += minCost
    }
  println(totalCost)
  }
}



