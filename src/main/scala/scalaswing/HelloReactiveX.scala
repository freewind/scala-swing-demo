package scalaswing

import rx.lang.scala.Observable
import rx.schedulers.SwingScheduler

import scala.swing.{Frame, MainFrame, SimpleSwingApplication, TextField}

object HelloReactiveX extends SimpleSwingApplication {

  // Note: need to add this to work with jdk 1.6
  // don't need this with jdk 1.7 & 1.8
  val eventScheduler = rx.lang.scala.JavaConversions.javaSchedulerToScalaScheduler(SwingScheduler.getInstance)

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

  stream.observeOn(eventScheduler).subscribe(t => println("###: " + t))

}

