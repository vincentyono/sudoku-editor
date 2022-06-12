package sudoku.editor.model;

/*
 *
 */

public class GridModel {
  private CellModel _sudokuGrid[][];

  public GridModel() {
    this._sudokuGrid = new CellModel[9][9];
  }

  public CellModel[][] getGrid() {
    return this._sudokuGrid;
  }
}
