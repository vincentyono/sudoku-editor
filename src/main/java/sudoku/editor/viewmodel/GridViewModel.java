package sudoku.editor.viewmodel;

import sudoku.editor.model.GridModel;

public class GridViewModel {
  private GridModel _grid;
  private CellViewModel _cellViewModel;
  private CellPencilNotesViewModel _cellPencilNotesViewModel;

  public GridViewModel() {
    this._grid = new GridModel();
  }
}
