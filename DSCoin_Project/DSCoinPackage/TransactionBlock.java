package DSCoinPackage;

import HelperClasses.MerkleTree;
import HelperClasses.CRF;

public class TransactionBlock {

  public Transaction[] trarray;
  public TransactionBlock previous;
  public TransactionBlock next;
  public MerkleTree Tree;
  public String trsummary;
  public String nonce;
  public String dgst;

  TransactionBlock(Transaction[] t) {
    trarray = new Transaction[t.length];
    for(int i = 0;i<t.length;i++){
      Transaction temp = new Transaction();
      temp = t[i];
      trarray[i] = new Transaction();
      trarray[i] = temp;
      
    }
    previous = null;
    Tree = new MerkleTree();
    trsummary = Tree.Build(t);
    dgst = null;
  }

  public boolean checkTransaction (Transaction t) {
    if(t.coinsrc_block == null) return true; //If the transaction is set by moderator or is reward transaction.

    boolean flag = true;
    //Checking if there is double spending.
    TransactionBlock curr = this;
    while(curr != t.coinsrc_block && curr!=null){
      boolean flag1 = false;
      for(int i = 0;i<curr.trarray.length;i++){
        if(curr.trarray[i].coinID.equals(t.coinID)){
          flag1 = true;
          break;
        }
      }
      if(flag1){
        flag = false;
        break;
      }
      curr = curr.previous;
    }
    if(curr == null) return false;
    if(!flag) return false;
    boolean flag2 = false;

    //Checking whether t.coinsrc_block contains the transaction or not.
    for(int i = 0;i<curr.trarray.length;i++){
        if(curr.trarray[i].coinID.equals(t.coinID) && (curr.trarray[i].Destination.UID.equals(t.Source.UID))){
          flag2 = true;
          break;
        }
    }
    return flag2;
  }
}
