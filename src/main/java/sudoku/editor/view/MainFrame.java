package sudoku.editor.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main Frame
 * Main window for sudoku editor
 */

public class MainFrame extends JFrame implements KeyListener {
  private boolean _isPencilNoteMode;
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

    this._isPencilNoteMode = false;

    this.setVisible(true);

    this.addKeyListener(this);
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

  public void togglePencilNotesMode() {
    this._isPencilNoteMode = !this._isPencilNoteMode;
    System.out.println(String.format("Pencil Mode: %b", this._isPencilNoteMode));
  }

  public boolean getIsPencilNoteMode() {
    return this._isPencilNoteMode;
  }

  private boolean isCellSelected() {
    return this.sudokuGridPanel.selectedX() >= 0 && this.sudokuGridPanel.selectedY() >= 0;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    switch (e.getKeyChar()) {
      case '1':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(1);
          } else {
            this.sudokuGridPanel.insertNumber(1);
          }
          break;
        }
      case '2':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(2);
          } else {
            this.sudokuGridPanel.insertNumber(2);
          }
          break;
        }
      case '3':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(3);
          } else {
            this.sudokuGridPanel.insertNumber(3);
          }
          break;
        }
      case '4':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(4);
          } else {
            this.sudokuGridPanel.insertNumber(4);
          }
          break;
        }
      case '5':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(5);

          } else {
            this.sudokuGridPanel.insertNumber(5);
          }
          break;
        }
      case '6':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(6);
          } else {
            this.sudokuGridPanel.insertNumber(6);
          }
          break;
        }
      case '7':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(7);
          } else {
            this.sudokuGridPanel.insertNumber(7);
          }
          break;
        }
      case '8':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(8);
          } else {
            this.sudokuGridPanel.insertNumber(8);
          }
          break;
        }
      case '9':
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
            this.sudokuGridPanel.togglePencilNotesNumber(9);
          } else {
            this.sudokuGridPanel.insertNumber(9);
          }
          break;
        }

      case 8: // BACKSPACE
        if (isCellSelected()) {
          if (this._isPencilNoteMode) {
          } else {
            this.sudokuGridPanel.insertNumber(0);
          }
        }

      case 'p':
        if (e.getKeyChar() == 'p') {
          this.togglePencilNotesMode();
        }
        break;

      default:
        break;
    }
  }
  @Override
  public void keyPressed(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}
}
