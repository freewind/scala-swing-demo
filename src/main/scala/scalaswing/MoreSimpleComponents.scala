package scalaswing

import scala.swing.Orientation._
import scala.swing._
import scalaswingcontrib.tree.{TreeModel, Tree}

object MoreSimpleComponents extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    title = "More components"
    minimumSize = new Dimension(300, 500)
    contents = new BoxPanel(Horizontal) {
      contents ++= Seq(new BoxPanel(Vertical) {
        contents += new Label("This is a label")
        contents += new TextField("A text field")
        contents += new Button("A button")
        contents += new BoxPanel(Horizontal) {
          contents ++= new ButtonGroup(new RadioButton("red"), new RadioButton("green")).buttons
        }
        contents += new BoxPanel(Horizontal) {
          contents ++= Seq(new CheckBox("rice"), new CheckBox("noodle"))
        }
      }, new BoxPanel(Vertical) {
        contents += new ListView(Seq("aaaaa", "bbbbb", "cccc"))
        contents += new Tree[Node[String]] {
          val menuItems = Node("Hobbies", Node("a11"), Node("a22"))
          model = TreeModel(menuItems)(_.children)
          renderer = Tree.Renderer(_.value)
        }
      })
    }
  }
}

case class Node[A](value: A, children: Node[A]*)
