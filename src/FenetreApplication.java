import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreApplication extends JFrame implements ActionListener {

	private JButton boutonImportation;
	private PlanCartesian canvas;
	private JFileChooser chooser;
	private ImporteurCartesien importeur;
	
	public FenetreApplication()
	{
		super();
		importeur = new ImporteurCartesien();
		chooser = new JFileChooser();
		boutonImportation = new JButton("Lire les donnees");
		this.add(boutonImportation);
		boutonImportation.addActionListener(this);
		canvas = new PlanCartesian();
		//this.add(canvas);

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		chooser.setCurrentDirectory(new File("."));
		
		chooser.showOpenDialog(null);
		
		if (chooser.APPROVE_OPTION == JFileChooser.APPROVE_OPTION)
		{
			importeur.Chargement(chooser.getSelectedFile().getName());
			LetsGo();
			
		}
		
		
	}
	
	
	private void LetsGo()
	{
		boutonImportation.setVisible(false);
		canvas.NouvelleSerie(importeur.getDerniereImportation(), importeur.getAxeX(), importeur.getAxeY());
		this.add(canvas);
		canvas.setVisible(true);
	}
	
	
}
