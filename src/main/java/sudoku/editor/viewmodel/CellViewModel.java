package sudoku.editor.viewmodel;

import sudoku.editor.model.CellModel;

public class CellViewModel {
  private int _x, _y;
  private CellModel _cellModel;

  public CellViewModel(int x, int y) {
    this._x = x;
    this._y = y;
    this._cellModel = new CellModel();
  }

  public int getCellNumber() {
    return _cellModel.getNumber();
  }

  public boolean[] getPencilNotes() {
    return _cellModel.getPencilNotes();
  }

  public int getX() {
    return this._x;
  }

  public int getY() {
    return this._y;
  }

  public void togglePencilNotes(int number) {
    if (number > 0 && number <= 9) {
      this._cellModel.togglePencilNotes(number);
    }
  }
}
