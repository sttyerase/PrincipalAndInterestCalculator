/* Created: Jan 9, 2015 */
package com.dbmi.money;

public class CalculatorModel {
   PICalc myCalc = new PICalc();

   public double calculate(double principal, double intrate, int months){
      return myCalc.calculatePayment(principal, intrate, months);
   } // CALCULATE(DOUBLE,DOUBLE,INT)

   public Double[][] getPayments(double principal, double intrate, int months){
      double thePmt = myCalc.calculatePayment(principal, intrate, months);
      return myCalc.calculatePaymentDetails(principal, intrate, months, thePmt);
   }

} // CLASS
