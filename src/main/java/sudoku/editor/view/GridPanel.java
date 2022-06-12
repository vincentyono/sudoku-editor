package sudoku.editor.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Sudoku Grid Panel
 * A view component that displays sudoku grid
 */

public class GridPanel extends JPanel {
  private final int WIDTH = 600;
  private final int HEIGHT = 600;
  private final int NUMBER_OF_ROWS = 9;
  private final int NUMBER_OF_COLUMNS = 9;

  public GridPanel() {
    this.setLayout(new GridLayout(this.NUMBER_OF_ROWS, this.NUMBER_OF_COLUMNS));
    this.setSize(new Dimension(this.WIDTH, this.HEIGHT));
    this.fillGridWithCells();
  }

  private void fillGridWithCells() {
    for (int i = 0; i < 81; i++) {
      this.add(new CellPanel());
    }

    // for (int i = 0; i < 81; i++) {
    //   this.add(new SudokuCellPanel(1));
    // }
  }
}
