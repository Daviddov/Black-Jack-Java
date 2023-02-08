import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardDrawing extends JPanel {
  private static final int CARD_WIDTH = 150;
  private static final int CARD_HEIGHT = 200;
  private static final Color CARD_COLOR = Color.WHITE;
  private static final Color BORDER_COLOR = Color.BLACK;
  private static final Color SYMBOL_COLOR = Color.RED;

  private String rank;
  private String suit;

  public CardDrawing(String rank, String suit) {
    this.rank = rank;
    this.suit = suit;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setColor(CARD_COLOR);
    g2d.fillRect(0, 0, CARD_WIDTH, CARD_HEIGHT);
    g2d.setColor(BORDER_COLOR);
    g2d.drawRect(0, 0, CARD_WIDTH, CARD_HEIGHT);

    g2d.setFont(new Font("Arial", Font.BOLD, 30));
    g2d.setColor(SYMBOL_COLOR);
    if (suit.equals("Hearts")) {
      int xPoints[] = {35, 65, 50};
      int yPoints[] = {85, 85, 60};
      int nPoints = 3;
      GeneralPath heart = new GeneralPath();
      heart.moveTo(xPoints[0], yPoints[0]);
      for (int i = 1; i < nPoints; i++) {
        heart.lineTo(xPoints[i], yPoints[i]);
      }
      heart.closePath();
      g2d.fill(heart);
    } else {
      g2d.drawString(rank + " " + suit, 30, 100);
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(CARD_WIDTH, CARD_HEIGHT);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new CardDrawing("10", "Hearts"));
    frame.pack();
    frame.setVisible(true);
  }
}
