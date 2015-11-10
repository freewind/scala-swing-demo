package scalaswing

import pl.metastack.metarx.Channel

import scala.swing.{TextField, MainFrame, Frame, SimpleSwingApplication}

object HelloMetaRx extends SimpleSwingApplication {

  val input = new TextField()

  override def top: Frame = new MainFrame {
    title = "Hello, metarx"
    contents = input
  }

  val textChanges = Channel[String]()
  textChanges.attach(t => println("### text change: " + t))

  input.subscribe {
    case _ =>
      println("input value is: " + input.text)
      textChanges := input.text
  }

}

