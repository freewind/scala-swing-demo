package scalaswing

import java.awt.Dimension

import scala.swing.BorderPanel.Position
import scala.swing._

object HelloBorderLayout extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    minimumSize = new Dimension(800, 600)
    contents = new BorderPanel {
      layout(new Button("North")) = Position.North
      layout(new Button("South")) = Position.South
      layout(new Button("West")) = Position.West
      layout(new Button("East")) = Position.East
      layout(new Button("Center")) = Position.Center
    }
  }
}
