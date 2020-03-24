package com.dbmi.money;

import java.util.*;

public class PiCalcJson {

    private String calculation = new String("");
    private StringBuilder sb   = new StringBuilder();
    private Formatter fmt      = new Formatter(sb);
    private double totpay      = 0;

   public String calculatePayment(double princp, double irate, int mon){
      Double [][] paydet;
      double payment = 0;
      fmt.format("{\"LOAN\" : { \"terms\" : { \"principal\" :  \"$%04.2f\" , \"interest rate\" : \"%04.2f%% (annual)\", \"months\" : \"%d\"} \n",princp,irate*12*100,mon);
      payment = (irate*princp)/(1-(java.lang.Math.pow((1+irate),-mon)));
      fmt.format("       { \"monthly payment\" : \"$%04.2f\" } \n",payment);
      paydet = calculatePaymentDetails(princp,irate,mon,payment);
      fmt.format(" { \"details\" : \n");
      for(int indx = 0 ; indx < mon ; indx++){
          fmt.format("{ \"detail\" : {\"month\" : \"%03d\" , \"interest payment\" : \"$%04.2f\" , \"principal paid\" : \"$%04.2f\" , \"principal balance\" : \"$%04.2f\" }\n",
                  indx + 1, paydet[indx][0],paydet[indx][1],paydet[indx][2]);       
          totpay += payment;
      // System.out.format("Total paid: $%04.2f.\n",21);
      } // FOR
      fmt.format(" } \n");
      fmt.format(" {\"total payments\" : \"$%04.2f\" } \n", totpay);
      fmt.format("}");
      calculation = calculation.concat(sb.substring(0));
      return calculation;
   } // CALCULATE(DOUBLE,DOUBLE,INT)

   public Double[][] calculatePaymentDetails(double princp, double irate, int mon, double pymt){
      Double[][] detail = new Double[mon][3];
      double totpay = 0;
      double intpaid = 0;
      double balance = princp;
      double prinpaid = 0;
      double payment = pymt;
      for(int i=0; i<mon; i++){
         intpaid  = irate * balance    ;  detail[i][0] = intpaid  ;
         prinpaid = payment - intpaid  ;  detail[i][1] = prinpaid ;
         balance = balance - prinpaid  ;  detail[i][2] = balance  ;
      } // FOR
      return detail;
   } // SHOWPAYMENTDETAILS(DOUBLE,DOUBLE,INT,DOUBLE)

   /*
    * Test the PICalc engine.
    */
   public static void main(String[] args){
      int    months    = 48;
      Double[][] payDetails = new Double[months][3];
      double principal = 25000.0;
      double intrate  = 0.0385/12;
      double pmt       = 0;
      PiCalcJson myCalc = new PiCalcJson();
      String result = myCalc.calculatePayment(principal,intrate,months);
      System.out.format("%s", result);
} // MAIN(STRING[])

} // CLASS
