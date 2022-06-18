package sudoku.editor.model;

public class CellModel {
  private int _number;
  private boolean[] _pencilNotes;

  public CellModel() {
    this.setNumber(0);
    this._pencilNotes = new boolean[9];
  }
  public CellModel(int number) {
    this.setNumber(number);
    this._pencilNotes = new boolean[9];
  }
  public CellModel(int number, boolean[] pencilNotes) {
    this.setNumber(number);
    this._pencilNotes = pencilNotes;
  }

  private boolean setNumber(int number) {
    if (number >= 0 && number <= 9) {
      this._number = number;
      return true;
    }
    return false;
  }

  public int getNumber() {
    return this._number;
  }

  public boolean[] getPencilNotes() {
    return this._pencilNotes;
  }

  public boolean togglePencilNotes(int number) {
    if (number >= 0 && number < 9) {
      this._pencilNotes[number - 1] = !this._pencilNotes[number - 1];
      return true;
    }
    return false;
  }
}
