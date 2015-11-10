package scalaswing

import java.awt.Dimension

import scala.swing.Orientation._
import scala.swing._
import scala.swing.event.ButtonClicked

object HelloGui extends SimpleSwingApplication {

  val button = new Button("Hello world!")

  override def top: Frame = new MainFrame {
    title = "Hello, scala swing"
    minimumSize = new Dimension(300, 300)
    contents = new BoxPanel(orientation = Horizontal) {
      contents += button
    }
  }

  button.subscribe {
    case ButtonClicked(_) => println("Button clicked")
  }

}
