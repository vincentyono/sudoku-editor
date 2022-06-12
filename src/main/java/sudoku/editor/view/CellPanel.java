package sudoku.editor.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Sudoku Cell Panel
 * A view component display cell of sudoku grid
 */

public class CellPanel extends JPanel implements MouseListener {
  private CellPencilNotesPanel _cellPencilNotesPanel;
  private JPanel _cellValuePanel;
  private JLabel _cellValueLabel;

  public CellPanel() {
    this.setLayout(new FlowLayout(FlowLayout.CENTER));
    this._cellPencilNotesPanel = new CellPencilNotesPanel();
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.add(_cellPencilNotesPanel);
    this._cellPencilNotesPanel.setVisible(false);
    this.addMouseListener(this);
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mousePressed(java.awt.event.MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseReleased(java.awt.event.MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseEntered(java.awt.event.MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseExited(java.awt.event.MouseEvent e) {
    // TODO Auto-generated method stub
  }
}
