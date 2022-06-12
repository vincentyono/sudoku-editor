package sudoku.editor.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main Frame
 * Main window for sudoku editor
 */

public class MainFrame extends JFrame {
  private GridPanel sudokuGridPanel;
  public MainFrame() {
    // Window Attribute
    this.setTitle("Sudoku Editor");
    this.setIconImage(new ImageIcon("images/sudoku_icon.png").getImage());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800, 800);
    this.setResizable(false);
    this.setLayout(new BorderLayout());

    // Initialize sudoku grid
    this.sudokuGridPanel = new GridPanel();

    // Add Padding
    this.add(this.yPadding(), BorderLayout.NORTH);
    this.add(this.xPadding(), BorderLayout.EAST);
    this.add(this.yPadding(), BorderLayout.SOUTH);
    this.add(this.xPadding(), BorderLayout.WEST);

    // Add Sudoku Grid
    this.add(this.sudokuGridPanel, BorderLayout.CENTER);

    this.setVisible(true);
  }

  // Left and right padding
  private JPanel xPadding() {
    JPanel xPadding = new JPanel();
    xPadding.setPreferredSize(new Dimension(50, 800));
    return xPadding;
  }

  // Top and bottom padding
  private JPanel yPadding() {
    JPanel yPadding = new JPanel();
    yPadding.setPreferredSize(new Dimension(800, 50));
    return yPadding;
  }
}
