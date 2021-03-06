object Solution {
  import scala.collection._


  def readInput(): List[List[Int]] = {
    val sc = new java.util.Scanner(System.in)

    val t = sc.nextInt
    val cases = new Array[List[Int]](t)
    for (i <- 0 until t) {
      val n = sc.nextInt
      val list = new Array[Int](n)
      for (j <- 0 until n) {
        list(j) = sc.nextInt
      }
      cases(i) = list.toList

    }

    cases.toList

  }

  case class Solution(numbers: List[Int]) {

    final def solve(): List[Int] = {

      val (leaders, _) = numbers.foldRight(List.empty[Int] -> Int.MinValue) { case (n, (leaders, min)) => 
        if (n > min) (n :: leaders, n)
        else (leaders, min)
      }
      leaders
    }

  }

  def main(args: Array[String]) = {
    val cases = readInput()
    for (c <- cases) println(Solution(c).solve().mkString(" "))
  }
}
