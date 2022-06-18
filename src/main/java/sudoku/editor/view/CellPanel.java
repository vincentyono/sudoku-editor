package sudoku.editor.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sudoku.editor.viewmodel.CellViewModel;

/**
 * Sudoku Cell Panel
 * A view component display cell of sudoku grid
 */

public class CellPanel extends JPanel implements MouseListener {
  private boolean _isSelected;
  private CellPencilNotesPanel _cellPencilNotesPanel;
  private JPanel _cellValuePanel;
  private JLabel _cellValueLabel;
  private CellViewModel _cellViewModel;
  private GridPanel _gridPanel;

  public CellPanel(int x, int y, GridPanel gridpanel) {
    this._gridPanel = gridpanel;
    this._cellViewModel = new CellViewModel(x, y);
    this._isSelected = false;
    this.setLayout(new FlowLayout(FlowLayout.CENTER));
    this._cellValuePanel = new JPanel();
    this._cellValueLabel = new JLabel();
    this._cellValuePanel.add(this._cellValueLabel);
    this._cellValueLabel.setFont(new Font(null, Font.BOLD, 50));
    this._cellValueLabel.setHorizontalAlignment(JLabel.CENTER);
    this._cellValueLabel.setVerticalAlignment(JLabel.CENTER);
    this._cellValueLabel.setVisible(true);
    this._cellValuePanel.setVisible(false);
    this.add(this._cellValueLabel);
    this.add(this._cellValuePanel);
    this._cellPencilNotesPanel = new CellPencilNotesPanel(this._cellViewModel);
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.add(_cellPencilNotesPanel);
    this._cellPencilNotesPanel.setVisible(true);
    this.addMouseListener(this);
  }

  public int getLocationX() {
    return this._cellViewModel.getX();
  }

  public int getLocationY() {
    return this._cellViewModel.getY();
  }

  public void select() {
    this._isSelected = true;
    this.setBackground(Color.CYAN);
    this._cellValuePanel.setBackground(Color.CYAN);
    this._cellValuePanel.setBackground(Color.CYAN);
  }

  public void deselected() {
    this.setBackground(null);
    this._cellValuePanel.setBackground(null);
  }

  public void insertNumber(int number) {
    if (number > 0 && number < 10) {
      this._cellValuePanel.setVisible(true);
      this._cellValueLabel.setVisible(true);
      this._cellPencilNotesPanel.setVisible(false);
      this._cellValueLabel.setText(Integer.toString(number));

    } else
      this._cellValueLabel.setText(" ");
  }

  public void insertPencilNoteNumber(int number) {
    if (number > 0 && number <= 9) {
      this._cellValuePanel.setVisible(false);
      this._cellValueLabel.setVisible(false);
      this._cellPencilNotesPanel.setVisible(true);
      this._cellPencilNotesPanel.toggleNumberVisibility(number);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    this._gridPanel.onSelectCell(this._cellViewModel.getX(), this._cellViewModel.getY());
    this.select();
    this._gridPanel.deselectCell();
    this._cellPencilNotesPanel.selectLabelBackground();
  }

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {
    if (!this._isSelected) {
      this.setBackground(new Color(0, 255, 255, 80)); // CYAN with Opacity
      this._cellValuePanel.setBackground(new Color(0, 255, 255, 80)); // CYAN with Opacity
      this._cellPencilNotesPanel.setBackground(new Color(0, 255, 255, 80));
      this._cellPencilNotesPanel.hoverLabelBackground();
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if (!this._isSelected) {
      this.setBackground(null);
      this._cellValuePanel.setBackground(null);
      this._cellPencilNotesPanel.setBackground(null);
      this._cellPencilNotesPanel.removeLabelBackground();
    }
  }
}
