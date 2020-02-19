import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Block {

    private int previousHash;
    Block next;
    int nextHash;
    int n;//number of transaction per block
    Transaction []t;

    public Block(int previousHash) throws IOException {
        this.previousHash = previousHash;
        next=null;
        insertTransaction();
        nextHash=0;
    }

    public void insertTransaction() throws IOException {

        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);

        System.out.println("Enter number of transactions:");
        //number of transactions
         n = Integer.parseInt(br.readLine());

         t = new Transaction[n];
        for(int i=0;i<n;i++) {
            t[i] = new Transaction();
        }
        for(int i=0;i<n;i++)
        {
            //take transaction details
            System.out.println("Transaction id:"+ (i+1) );
            System.out.println("sender:");
            t[i].sender= br.readLine();
            System.out.println("receiver:");
            t[i].reciver= br.readLine();
            System.out.println("amount:");
            t[i].amount= Long.parseLong(br.readLine());
        }
    }

    public void showBlock(){

        System.out.println("Block Details:");
        System.out.println("Previous Hash:"+this.previousHash);
        System.out.println("Next Hash:"+this.nextHash);
        System.out.println("No. of transactions:"+this.n);

        for(int i=0;i<n;i++)
        {
            t[i].showTransaction();
        }

    }

}
