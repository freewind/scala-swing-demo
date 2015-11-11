package scalaswing

import scala.swing.Orientation._
import scala.swing._

object HelloListenToAndReactions extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    contents = new BoxPanel(Vertical) {
      val username = new TextField("username")
      contents ++= Seq(
        username,
        new TextField("") {
          listenTo(username)
          reactions += {
            case _ => println("changed: " + username.text + ", " + this.text)
          }
        }
      )
    }
  }
}
