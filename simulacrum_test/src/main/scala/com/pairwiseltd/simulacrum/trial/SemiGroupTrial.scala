package com.pairwiseltd.simulacrum.trial

import simulacrum._


object SemiGroupTrial{

  @typeclass trait SemiGroup[A] {
    @op("|+|") def append(x: A, y: A): A
  }

  object SomeSemiGroups {
    implicit val semigroupInt: SemiGroup[Int] = new SemiGroup[Int] {
      def append(x: Int, y: Int) = x + y
    }
    implicit val semigroupStr: SemiGroup[String] = new SemiGroup[String] {
      def append(x: String, y: String) = x + y
    }
  }

  def main(args: Array[String]): Unit = {
    someMethod

  }

  def someMethod ={
    import SomeSemiGroups._
    import SemiGroup.ops._

    println(1 |+| 2) // 3
    println("3" |+| "4")
  }
}







