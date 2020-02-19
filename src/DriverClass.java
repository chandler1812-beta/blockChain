import java.io.IOException;

class Chain{

    Block genesis;

    int chainHash;
    Chain() throws IOException {
        System.out.println("genesis:");
        genesis = new Block(0);
        genesis.next=null;
        chainHash= genesis.hashCode();
        genesis.nextHash=0;
    }
    void insert() throws IOException {
        Block nb= new Block(chainHash);

        if(genesis.next==null)
        {
            genesis.next=nb;
            genesis.nextHash= nb.hashCode();
        }
        else
        {
            Block temp;
            temp= genesis;
            while(temp.next!=null)
            {
                temp=temp.next;
            }temp.next=nb;
            temp.nextHash= nb.hashCode();
        }
        chainHash= nb.hashCode();
    }
    void displayChain(){

        Block temp;
        temp = genesis;

        while(temp.next!=null)
        {
            temp.showBlock();
            System.out.println();
            temp=temp.next;
        }temp.showBlock();
        temp=temp.next;
    }

}


public class DriverClass {

    /*
    * to create a geneis block
    *       insert n transactions
    *
    * to create any other block in the chain
    *       insert n transaction and automatically take previous hash
    * */

    public static void main(String []args) throws IOException {

        Chain c= new Chain();
        c.insert();
        c.displayChain();
    }
}
