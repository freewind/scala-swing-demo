package scalaswing

import rx.lang.scala.Observable

import scala.swing.{Frame, MainFrame, SimpleSwingApplication, TextField}

object HelloReactiveX extends SimpleSwingApplication {

  val input = new TextField()

  override def top: Frame = new MainFrame {
    title = "Hello, reactivex"
    contents = input
  }

  val stream = Observable[String] { subscriber =>
    println("before input.subscribe")
    input.subscribe {
      case _ => {
        println("input changed: " + input.text)
        subscriber.onNext(input.text)
      }
    }
    println("after input.subscribe")
  }

  stream.subscribe(t => println("###: " + t))

}

