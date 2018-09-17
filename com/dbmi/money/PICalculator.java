/* Created: Dec 18, 2015 */
package com.dbmi.money;

public class PICalculator {

   PICalculator(){
      CalculatorModel theModel = new CalculatorModel();
      CalculatorView  theView  = new CalculatorView(theModel);
      CalculatorController theController = new CalculatorController(theModel,theView);
   } // NULL CONSTRUCTOR

   @SuppressWarnings("unused")
   public static void main(String[] args){
      PICalculator calculator = new PICalculator();
} // MAIN(STRING[])

} // CLASS
