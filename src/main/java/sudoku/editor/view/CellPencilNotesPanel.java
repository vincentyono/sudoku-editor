package sudoku.editor.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sudoku.editor.viewmodel.CellViewModel;

public class CellPencilNotesPanel extends JPanel {
  private JLabel _pencilNotes[];
  private CellViewModel _cellViewModel;
  private final int NUMBER_OF_ROWS = 3;
  private final int NUMBER_OF_COLUMNS = 3;
  private final int XGAP = 10;
  private final int YGAP = 5;

  public CellPencilNotesPanel(CellViewModel cellViewModel) {
    this._cellViewModel = cellViewModel;
    this.setLayout(
        new GridLayout(this.NUMBER_OF_ROWS, this.NUMBER_OF_COLUMNS, this.XGAP, this.YGAP));
    this._pencilNotes = new JLabel[9];

    for (int i = 0; i < this.NUMBER_OF_ROWS * this.NUMBER_OF_COLUMNS; i++) {
      this._pencilNotes[i] = new JLabel();
      this._pencilNotes[i].setForeground(Color.GRAY);
      this._pencilNotes[i].setText(String.format("%d", i + 1));
      this._pencilNotes[i].setVisible(this._cellViewModel.getPencilNotes()[i]);
      this.add(this._pencilNotes[i]);
    }
  }

  public void toggleNumberVisibility(int number) {
    if (number > 0 && number <= 9) {
      this._cellViewModel.togglePencilNotes(number);
      this._pencilNotes[number - 1].setVisible(this._cellViewModel.getPencilNotes()[number - 1]);
    }
  }

  public void selectLabelBackground() {
    for (int i = 0; i < this._pencilNotes.length; i++) {
      this._pencilNotes[i].setBackground(Color.CYAN);
    }
  }

  public void hoverLabelBackground() {
    for (int i = 0; i < this._pencilNotes.length; i++) {
      this._pencilNotes[i].setBackground(new Color(0, 255, 255, 80));
    }
  }

  public void removeLabelBackground() {
    for (int i = 0; i < this._pencilNotes.length; i++) {
      this._pencilNotes[i].setBackground(null);
    }
    this.setBackground(null);
  }
}
