package com.dbmi.money;

public class PICalc {

   public double calculatePayment(double princp, double irate, int mon){
      double payment = 0;
      System.out.format("Calculating principal and interest payment on: %04.2f @ %04.2f%%.\n",princp,irate*12*100);
      payment = (irate*princp)/(1-(java.lang.Math.pow((1+irate),-mon)));
      return payment;
   } // CALCULATE(DOUBLE,DOUBLE,INT)

   public Double[][] calculatePaymentDetails(double princp, double irate, int mon, double pymt){
      Double[][] paystuff = new Double[mon][3];
      double totpay = 0;
      double intpaid = 0;
      double balance = princp;
      double prinpaid = 0;
      double payment = pymt;
      for(int i=0; i<mon; i++){
         intpaid  = irate * balance    ;  paystuff[i][0] = intpaid  ;
         prinpaid = payment - intpaid  ;  paystuff[i][1] = prinpaid ;
         balance = balance - prinpaid  ;  paystuff[i][2] = balance  ;
         totpay += payment;
      } // FOR
      System.out.format("Total paid: $%04.2f.\n",totpay);
      return paystuff;
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
      PICalc myCalc = new PICalc();
      pmt = myCalc.calculatePayment(principal,intrate,months);
      System.out.format("Payment: $%04.2f per period.\n",pmt);
      payDetails = myCalc.calculatePaymentDetails(principal,intrate,months,pmt);
      for(int indx = 0 ; indx < months ; indx++){
         System.out.format("Interest payment: $%04.2f <==> principal paid: $%04.2f <==> principal balance: $%04.2f\n",payDetails[indx][0],payDetails[indx][1],payDetails[indx][2]);       
      } // FOR
} // MAIN(STRING[])

} // CLASS
