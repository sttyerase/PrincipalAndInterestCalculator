/* Created: Jan 9, 2015 */
package com.dbmi.money;
import javax.swing.*;
import java.awt.*;

public class CalculatorView {
   private JFrame        theFrame          = new JFrame("PRINCIPAL and INTEREST CALCULATOR");
   private Container     contentPane       = null;
   // FUNCTIONAL COMPONENTS
   private Color         labelForeGround   = new Color(80,130,40);
   private JTextArea     theTextArea       = new JTextArea();
   private JTextField    intRateField      = new JTextField();
   private JLabel        intRateLabel      = new JLabel("Interest Rate (%)");
   private JTextField    principalField    = new JTextField();
   private JLabel        principalLabel    = new JLabel("Principal Amount");
   private JTextField    periodField       = new JTextField();
   private JLabel        periodLabel       = new JLabel("Months of Loan");
   private JRadioButton  periodLengthField = new JRadioButton();             // TODO: ENHANCE CALCULATIONS
   private JLabel        periodLengthLabel = new JLabel("Length of Period");
   private JButton       exitButton        = new JButton("QUIT");
   private JButton       submitButton      = new JButton("SUBMIT");
   private JButton       clearTextButton   = new JButton("CLEAR TEXT");
   // PANELS
   private JPanel        controlsPanel     = new JPanel();
   private JPanel        inputsPanel       = new JPanel();
   private JPanel        displayPanel      = new JPanel();
   // LAYOUT MANAGERS
   private GridBagLayout inputsLayout      = new GridBagLayout();
   private GridBagConstraints inputsConstraints = new GridBagConstraints();
   private GridLayout    controlsLayout    = new GridLayout(3,1);
   private BorderLayout  displayLayout     = new BorderLayout();
   // THE MODEL
   private CalculatorModel theModel       = null;

   public CalculatorView(CalculatorModel aModel){
      this.theModel = aModel;
      this.buildDisplay();
   } // CONSTRUCTOR(CALCULATORMODEL)

   public void buildDisplay(){
      // BUILD THE INPUTS PANEL
      intRateField.add(intRateLabel);
      intRateLabel.setForeground(labelForeGround);
      inputsPanel.setLayout(inputsLayout);
      inputsLayout.setConstraints(inputsPanel, inputsConstraints);
      inputsConstraints.gridheight=3;
      inputsConstraints.gridwidth=2;
      inputsConstraints.gridx=GridBagConstraints.NORTHWEST;
      inputsConstraints.gridy=GridBagConstraints.ABOVE_BASELINE_LEADING;
      inputsPanel.add(intRateLabel);
      inputsPanel.add(intRateField);
      inputsPanel.add(principalLabel);
      inputsPanel.add(principalField);
      inputsPanel.add(principalField);
      inputsPanel.add(periodLabel);
      inputsPanel.add(periodField);
      inputsPanel.add(periodLengthLabel);
      inputsPanel.add(periodLengthField);
      inputsPanel.setPreferredSize(new Dimension(900,200));
      inputsPanel.setBackground(new Color(255,225,230));
      // BUILD THE DISPLAY PANEL
      theTextArea.setBackground(new Color(255,210,200));
      theTextArea.setText("ENTER INTEREST RATE, MONTHS AND PRINCIPAL TO BEGIN: \n");
      theTextArea.setPreferredSize(new Dimension(900,500));
      displayLayout.addLayoutComponent(theTextArea, BorderLayout.CENTER);
      displayPanel.setLayout(displayLayout);
      displayPanel.add(theTextArea);
      displayPanel.setPreferredSize(new Dimension(900,500));
      displayPanel.setBounds(5, 5, 5, 5);
      // BUILD THE CONTROLS PANEL
      controlsLayout.addLayoutComponent("SUBMIT", submitButton);
      controlsLayout.addLayoutComponent("CLEARTEXT",clearTextButton);
      controlsLayout.addLayoutComponent("EXIT",exitButton);
      controlsPanel.add(submitButton);
      controlsPanel.add(clearTextButton);
      controlsPanel.add(exitButton);
      controlsPanel.setPreferredSize(new Dimension(900,50));
      // BUILD THE MAIN FRAME
      contentPane = theFrame.getContentPane();
      contentPane.add(inputsPanel,BorderLayout.PAGE_START);
      contentPane.add(displayPanel,BorderLayout.CENTER);
      contentPane.add(controlsPanel,BorderLayout.PAGE_END);
      // DISPLAY THE FRAME TO THE USER
      theFrame.setSize(900, 700);
      theFrame.setVisible(true);
   } // BUILDDISPLAY()

   // GETTERS - BUTTONS
   public JButton getExitButton() {
      return exitButton;
   } // GETEXITBUTTON()

   public JButton getSubmitButton() {
      return submitButton;
   } // GETSUBMITBUTTON()

   public JButton getClearTextButton(){
      return clearTextButton;
   }

   // GETTERS - OTHER COMPONENTS
   public JTextArea getTheTextArea(){
      return theTextArea;
   }

   // GETTERS - MAIN FRAME
   public JFrame getTheFrame() {
      return theFrame;
   } // GETTHEFRAME()

} // CLASS
