package scalaswing

import scala.swing.Orientation._
import scala.swing._
import scala.swing.event.ButtonClicked

object HelloDynamicButtons extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {frame =>
    contents = new BoxPanel(Vertical) {
      lazy val number = new TextField(1)
      lazy val okButton = new Button("OK")

      contents += new BoxPanel(Horizontal) {
        contents += number
        contents += okButton
      }
      contents += new BoxPanel(Horizontal) {
        listenTo(okButton)
        reactions += {
          case ButtonClicked(_) =>
            val n = number.text.toInt
            println("### n: " + n)
            contents += new Button(n.toString)
        }
      }
    }
    pack()
    centerOnScreen()
    open()
  }


}
