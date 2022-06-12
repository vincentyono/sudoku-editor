package sudoku.editor.model;

public class CellModel {
  private int _value;
  private boolean[] _pencilNotes;

  public CellModel() {
    this.setValue(0);
    this._pencilNotes = new boolean[9];
  }
  public CellModel(int value) {
    this.setValue(value);
    this._pencilNotes = new boolean[9];
  }
  public CellModel(int value, boolean[] pencilNotes) {
    this.setValue(value);
    this._pencilNotes = pencilNotes;
  }

  private boolean setValue(int value) {
    if (value >= 0 && value <= 9) {
      this._value = value;
      return true;
    }
    return false;
  }

  public int getValue() {
    return this._value;
  }

  public boolean[] getPencilNotes() {
    return this._pencilNotes;
  }
}
