package sudoku.editor.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Sudoku Grid Panel
 * A view component that displays sudoku grid
 */

public class GridPanel extends JPanel {
  // Grid size on screen
  private final int WIDTH = 600;
  private final int HEIGHT = 600;

  // Grid row and column length
  private final int NUMBER_OF_ROWS = 9;
  private final int NUMBER_OF_COLUMNS = 9;

  private CellPanel _cellPanels[][];

  // Index of selected cell
  private int _x;
  private int _y;

  public GridPanel() {
    this._x = -1;
    this._y = -1;
    this.setLayout(new GridLayout(this.NUMBER_OF_ROWS, this.NUMBER_OF_COLUMNS));
    this.setSize(new Dimension(this.WIDTH, this.HEIGHT));
    this._cellPanels = new CellPanel[9][9];
    this.fillGridWithCells();
  }

  private void fillGridWithCells() {
    for (int i = 0; i < this.NUMBER_OF_COLUMNS; i++) {
      for (int j = 0; j < this.NUMBER_OF_ROWS; j++) {
        this._cellPanels[j][i] = new CellPanel(j, i, this);
        this.add(this._cellPanels[j][i]);
      }
    }
  }

  public int selectedX() {
    return this._x;
  }

  public int selectedY() {
    return this._y;
  }

  public void onSelectCell(int y, int x) {
    this._x = x;
    this._y = y;
  }

  public void insertNumber(int number) {
    boolean isValid = true;
    int x = -1, y = -1;

    for (int i = 0; i < this.NUMBER_OF_COLUMNS; i++) {
      if (this._cellPanels[i][this.selectedX()].getNumber() == number) { // check columns
        isValid = false;
      }
      if (this._cellPanels[this.selectedY()][i].getNumber() == number) { // check rows
        isValid = false;
      }
    }

    if (this.selectedX() <= 2 && this.selectedX() >= 0)
      x = 0;
    if (this.selectedX() <= 5 && this.selectedX() >= 3)
      x = 3;
    if (this.selectedX() <= 8 && this.selectedX() >= 6)
      x = 6;

    if (this.selectedY() <= 2 && this.selectedY() >= 0)
      y = 0;
    if (this.selectedY() <= 5 && this.selectedY() >= 3)
      y = 3;
    if (this.selectedY() <= 8 && this.selectedY() >= 6)
      y = 6;

    for (int i = x; i < x + 3; i++) {
      for (int j = y; j < y + 3; j++) {
        if (this._cellPanels[j][i].getNumber() == number) {
          isValid = false;
        }
      }
    }

    if (isValid) {
      this._cellPanels[this.selectedY()][this.selectedX()].insertNumber(number);
    }
  }
  public void deselectCell() {
    for (int y = 0; y < this.NUMBER_OF_COLUMNS; y++) {
      for (int x = 0; x < this.NUMBER_OF_ROWS; x++) {
        if (this._y == y && this._x == x) {
        } else {
          this._cellPanels[y][x].deselected();
        }
      }
    }
  }

  public void togglePencilNotesNumber(int number) {
    this._cellPanels[this._y][this._x].insertPencilNoteNumber(number);
  }
}
