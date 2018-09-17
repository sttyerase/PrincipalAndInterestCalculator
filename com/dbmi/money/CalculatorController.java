/* Created: Jan 9, 2015 */
package com.dbmi.money;
import java.awt.event.*;

public class CalculatorController implements ActionListener{

   private CalculatorModel theModel = null;
   private CalculatorView  theView  = null;

   public CalculatorController(CalculatorModel aModel,CalculatorView aView){
      this.theModel = aModel;
      this.theView  = aView;
      // ADD CONTROLLER TO GESTURE OBJECTS IN THE VIEW
      theView.getExitButton().addActionListener(this);
      theView.getSubmitButton().addActionListener(this);
      theView.getClearTextButton().addActionListener(this);
   } // CONSTRUCTOR(CALCULATORMODEL,CALCULATORVIEW)

   public void actionPerformed(ActionEvent e){
      if(e.getSource() == theView.getExitButton()){
         theView.getTheFrame().dispose();
         System.exit(0);
      } else if(e.getSource() == theView.getSubmitButton()){
         // TODO: get values and display results
      } else if(e.getSource() == theView.getClearTextButton()){
         theView.getTheTextArea().setText("");
      } // IF-ELSE
   } // ACTIONPERFORMED(ACTIONEVENT)

} // CLASS
