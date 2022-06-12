package sudoku.editor.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CellPencilNotesPanel extends JPanel {
  private JLabel _pencilNotes[];
  private final int NUMBER_OF_ROWS = 3;
  private final int NUMBER_OF_COLUMNS = 3;
  private final int XGAP = 10;
  private final int YGAP = 5;

  public CellPencilNotesPanel() {
    this.setLayout(
        new GridLayout(this.NUMBER_OF_ROWS, this.NUMBER_OF_COLUMNS, this.XGAP, this.YGAP));
    this._pencilNotes = new JLabel[9];

    for (JLabel pencilNote : this._pencilNotes) {
      pencilNote = new JLabel();
      pencilNote.setText("1");
      this.add(pencilNote);
    }
  }
}
