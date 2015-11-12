package scalaswing.reactivex

import rx.lang.scala.subjects.PublishSubject
import rx.schedulers.SwingScheduler

import scala.swing.Orientation._
import scala.swing._
import scala.swing.event.ValueChanged

object HelloSubject extends SimpleSwingApplication {

  val subject = PublishSubject[String]

  override def top: Frame = new MainFrame {
    contents = new BoxPanel(Vertical) {
      contents += new TextField {
        reactions += {
          case ValueChanged(_) => subject.onNext("from 1: " + text)
        }
      }
      contents += new TextField {
        reactions += {
          case ValueChanged(_) => subject.onNext("from 2: " + text)
        }
      }
    }
  }

  val eventScheduler = rx.lang.scala.JavaConversions.javaSchedulerToScalaScheduler(SwingScheduler.getInstance)

  subject.observeOn(eventScheduler).subscribe(text => println(text))

}
