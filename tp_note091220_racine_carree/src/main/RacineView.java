package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RacineView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelControl;
	
	private JTextField ValueA;
	private JTextField ValueB;
	
	private JButton validateRacine;
	
	private Racine racine;
	
	public RacineView(){
		racine = new Racine();
		RacineFrame(); 
	}
	
	public void RacineFrame() {
		this.setTitle("Racine Carrée");
		this.setSize(400, 350);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());	
		
		this.panelControl = new JPanel();
		this.panelControl.setPreferredSize(new Dimension(400, 200));
		this.panelControl.setBorder((BorderFactory.createTitledBorder("Racine Carrée")));
		
		this.ValueA = new JTextField();
		this.ValueB = new JTextField();
			
		JLabel lblValueA= new JLabel("Valeur A : ", JLabel.CENTER);
		lblValueA.setLabelFor(ValueA);
		    
		JLabel lblValueB = new JLabel("Valeur B : ", JLabel.CENTER);
		lblValueB.setLabelFor(ValueB);
		
		this.validateRacine = new JButton("<html><font color='green'>Calcul de racine carrée</font></html>");
		this.validateRacine.setBounds(50, 10, 50, 25);
		
		final boolean shouldFill = true;
		final boolean shouldWeightX = true;
		this.panelControl.setLayout(new GridBagLayout());
		GridBagConstraints formElementConstraint = new GridBagConstraints();
		
		 if (shouldFill) {
            //natural height, maximum width
	    	formElementConstraint.fill = GridBagConstraints.HORIZONTAL;
	    }
		    
	    if (shouldWeightX) {
	        formElementConstraint.weightx = 0.5;
	    }
		
	    formElementConstraint.fill = GridBagConstraints.HORIZONTAL;
	    formElementConstraint.weighty = 0.1;	    
	    formElementConstraint.gridx = 0;
	    formElementConstraint.gridy = 0;	    
	    this.panelControl.add(lblValueA, formElementConstraint);    
	   
	    formElementConstraint.fill = GridBagConstraints.HORIZONTAL;
	    formElementConstraint.weighty = 0.1;
	    formElementConstraint.ipady = 4; 
	    formElementConstraint.gridx = 1;
	    formElementConstraint.gridy = 0;
	    this.panelControl.add(ValueA, formElementConstraint);
	    
		
	    formElementConstraint.fill = GridBagConstraints.HORIZONTAL;
	    formElementConstraint.weighty = 0.1; 
	    formElementConstraint.gridx = 0;
	    formElementConstraint.gridy = 1; 
	    this.panelControl.add(lblValueB, formElementConstraint);

	    formElementConstraint.fill = GridBagConstraints.HORIZONTAL;
	    formElementConstraint.weighty = 0.1; 
	    formElementConstraint.ipady = 4;
	    formElementConstraint.gridx = 1; 
	    formElementConstraint.gridy = 1;
	    this.panelControl.add(ValueB, formElementConstraint);
		 
	    
	    formElementConstraint.fill = GridBagConstraints.HORIZONTAL;
	    formElementConstraint.ipady = 4; 
	    formElementConstraint.weighty = 0.1;
	    formElementConstraint.gridwidth = 2;
	    formElementConstraint.gridx = 0;
	    formElementConstraint.gridy = 2;
	    this.panelControl.add(validateRacine, formElementConstraint);
	    
	    this.getContentPane().add(panelControl,BorderLayout.CENTER);
	    
	    validateRacine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ValueA.getText().trim().length()!=0 && ValueB.getText().trim().length()!=0) {
					Validation();
				}
				else
					errorInput();					
			}
	    });
	}
	
	private void Validation() {		
		String message="";
		try {
			int valueA = Integer.parseInt(ValueA.getText());
			int valueB = Integer.parseInt(ValueB.getText());
			HashMap<Integer, Double> allRacine = racine.allSqrt(valueA, valueB);			
			for(HashMap.Entry<Integer, Double> data : allRacine.entrySet()) {
				message += "Nombre : " + data.getKey() + "\nRacine carrée : " + data.getValue() + "\n\n";
			}
			JOptionPane.showMessageDialog(this,message,"Résultats",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,e1.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void errorInput() {
		String errorM="Veuillez remplir les Valeurs A et B";
		JOptionPane.showMessageDialog(this,errorM,"Erreur",JOptionPane.ERROR_MESSAGE);
		
	}
}
