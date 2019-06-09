package chapter02

import cats._
import cats.data._
import cats.implicits._

sealed trait TrafficLight

object TrafficLight {
  def red: TrafficLight = Red
  def yellow: TrafficLight = Yellow
  def green: TrafficLight = Green

  case object Red extends TrafficLight
  case object Yellow extends TrafficLight
  case object Green extends TrafficLight
}

object Signal extends App {

  implicit val trafficLightEq: Eq[TrafficLight] =
    // Eq has nonvariant subtyping.
    new Eq[TrafficLight] {
      def eqv(a1: TrafficLight, a2: TrafficLight): Boolean = a1 == a2
    }

  //TrafficLight.Red === TrafficLight.Yellow // Compilation failed.
  TrafficLight.red === TrafficLight.yellow
}
