public class Transaction {

     String sender;
     String reciver;
     long amount;

     void showTransaction()
     {
          System.out.println("     sender:"+this.sender);
          System.out.println("     reciever:"+this.reciver);
          System.out.println("     amount:"+this.amount);
          System.out.println();
     }
}
