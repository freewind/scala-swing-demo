package scalaswing

import scala.swing.Orientation._
import scala.swing._

object MoreSimpleComponents extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    title = "More components"
    minimumSize = new Dimension(300, 500)
    contents = new BoxPanel(Vertical) {
      contents += new Label("This is a label")
      contents += new TextField("A text field")
      contents += new Button("A button")
      contents += new BoxPanel(Horizontal) {
        contents ++= new ButtonGroup(new RadioButton("red"), new RadioButton("green")).buttons
      }
      contents += new BoxPanel(Horizontal) {
        contents ++= Seq(new CheckBox("rice"), new CheckBox("noodle"))
      }
    }
  }
}
