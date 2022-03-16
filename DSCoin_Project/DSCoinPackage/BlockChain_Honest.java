package DSCoinPackage;

import HelperClasses.*;

public class BlockChain_Honest {

  public int tr_count;
  public static final String start_string = "DSCoin";
  public TransactionBlock lastBlock;

  public void InsertBlock_Honest (TransactionBlock newBlock) {
  	CRF obj = new CRF(64);
	String dummy = new String();
	if(this.lastBlock == null) dummy = start_string;
	else dummy = this.lastBlock.dgst;
	
	//nonce and dgst computation
	
	for(long i = 1000000001L;i<=9999999999L;i++){
		String dummy2 = obj.Fn(dummy+"#"+newBlock.trsummary+"#"+Long.toString(i));
		if(dummy2.substring(0,4).equals("0000")){
			newBlock.dgst = dummy2;
			newBlock.nonce = Long.toString(i);
			break;
		}
	}
	
	if(this.lastBlock == null){
		tr_count = newBlock.trarray.length;
		this.lastBlock = newBlock;
	}
	
	else{
		tr_count = newBlock.trarray.length;
		newBlock.previous = this.lastBlock;
		this.lastBlock.next = newBlock;
		this.lastBlock = newBlock; 
	}
  }
}
