package DSCoinPackage;

import java.util.*;
import HelperClasses.*;

public class Members
 {

  public String UID;
  public List<Pair<String, TransactionBlock>> mycoins = new ArrayList<Pair<String,TransactionBlock>>();
  public Transaction[] in_process_trans = new Transaction[100];
  public int currlen = 0;

  public void initiateCoinsend(String destUID, DSCoin_Honest DSobj) {
  	Transaction tobj = new Transaction();
	tobj.coinID = mycoins.get(0).first;
	tobj.coinsrc_block = mycoins.get(0).second;
	tobj.Source = this;

	//finding the destination member object.
	for(int i = 0;i<DSobj.memberlist.length;i++){
		if(DSobj.memberlist[i].UID.equals(destUID)){
			tobj.Destination =DSobj.memberlist[i];
			break;
		}
	}
	if(this.currlen<0) this.currlen = 0;
	
	this.in_process_trans[this.currlen] = tobj;
	DSobj.pendingTransactions.AddTransactions(tobj);
	mycoins.remove(0);
	this.currlen++;
  }

  public void initiateCoinsend(String destUID, DSCoin_Malicious DSobj) {
  	Transaction tobj = new Transaction();
	tobj.coinID = mycoins.get(0).first;
	tobj.coinsrc_block = mycoins.get(0).second;
	tobj.Source = this;
	for(int i = 0;i<DSobj.memberlist.length;i++){
		if(DSobj.memberlist[i].UID.equals(destUID)){
			tobj.Destination =DSobj.memberlist[i];
			break;
		}
	}
	if(this.currlen<0) this.currlen = 0;
	this.in_process_trans[this.currlen] = tobj;
	DSobj.pendingTransactions.AddTransactions(tobj);
	mycoins.remove(0);
	this.currlen++;
  }


  public Pair<List<Pair<String, String>>, List<Pair<String, String>>> finalizeCoinsend (Transaction tobj, DSCoin_Honest DSObj) throws MissingTransactionException {
    	List<Pair<String,String>> path = new ArrayList<Pair<String,String>>();
	TransactionBlock curr = DSObj.bChain.lastBlock;
	TransactionBlock curr1 = DSObj.bChain.lastBlock;
	boolean flag = false;
	int idx = -1;
	//for(int i = 0;i<curr.trarray.length;i++){
	//	System.out.println(curr.trarray[i].coinID);	
	//}
	//finding the block containing transaction tobj.
	while(curr!=null){
		for(int i = 0;i<curr.trarray.length;i++){
			//System.out.println(curr.trarray[i].coinID +" "+tobj.coinID);
			if(curr.trarray[i] == tobj){
				flag = true;
				idx = i;
				curr1 = curr;
				break;
			}
		}
		if(flag) break;
		curr = curr.previous;
	}
        
	if(!flag) throw new MissingTransactionException();

	//Sibling coupled path calculation
	TreeNode node = curr.Tree.rootnode;
	int len = curr.trarray.length;
	path.add(new Pair<String,String>(node.val,null));
	while(node.left != null){
		path.add(new Pair<String,String>(node.left.val,node.right.val));
		if(idx >= (len/2)){
			node = node.right;
			len = len/2;
			idx = idx - len;
		}
		else{
			node = node.left;
			len = len/2;
		}
	}
	Collections.reverse(path);
 	
	//Calculation of second path
	List<Pair<String,String>> pair2 = new ArrayList<Pair<String,String>>();
	String dummy;
	if(curr.previous == null) dummy = DSObj.bChain.start_string;
	else dummy = curr.previous.dgst;
	
	pair2.add(new Pair<String,String>(dummy,null));
	
	while(curr != null){
		pair2.add(new Pair<String,String>(curr.dgst,dummy + "#" + curr.trsummary + "#" + curr.nonce));
		dummy = curr.dgst;
		curr = curr.next;
	}
	
	//Removing tobj from in_process_trans
	int k;
	for(k = 0;k<100;k++){
		if(this.in_process_trans[k].coinID.equals(tobj.coinID)) break;
	}
	for(int i = k+1;i<100;i++){
		this.in_process_trans[i-1] = this.in_process_trans[i];
	}
	this.currlen-=1;

	//Adding coin to the mycoins list of Destination.
	int i;
	boolean flag2 = false;
        for(i = 0;i<tobj.Destination.mycoins.size();i++){
		if(tobj.Destination.mycoins.get(i) == null) break;
		if(tobj.coinID.compareTo(tobj.Destination.mycoins.get(i).first) == 0) {flag2 = true;break;}
		if(tobj.coinID.compareTo(tobj.Destination.mycoins.get(i).first) < 0) break;	
	}
	if(flag2) return new Pair<List<Pair<String, String>>, List<Pair<String, String>>>(path,pair2);
	if(i == tobj.Destination.mycoins.size()){
		tobj.Destination.mycoins.add(new Pair<String,TransactionBlock>(tobj.coinID,curr1));
	}
	else{
		tobj.Destination.mycoins.add(i, new Pair<String,TransactionBlock>(tobj.coinID,curr1));
	}

	return new Pair<List<Pair<String, String>>, List<Pair<String, String>>>(path,pair2);
	
	

  }

  public void MineCoin(DSCoin_Honest DSObj) {
	int count = 0;
	Transaction[] t = new Transaction[DSObj.bChain.tr_count];

	//declared a hashmap to check whether pending transactions has two coins of same ID. 
	HashMap<String,Integer> m = new HashMap<String,Integer>();
	try{
		while(count != DSObj.bChain.tr_count - 1 && (DSObj.pendingTransactions.numTransactions > 0)){
			Transaction newtr = DSObj.pendingTransactions.RemoveTransaction();
			String obj = new String();
			obj = newtr.coinID;
			if(!DSObj.bChain.lastBlock.checkTransaction(newtr)) {continue;}
			if(m.get(obj) == null){
				m.put(obj,1);
			}
			else continue;
			t[count] = newtr;
			count++;
		}
	}catch(EmptyQueueException e){}

	//Minor reward transaction.
	Transaction minorB = new Transaction();

	int temp = Integer.parseInt(DSObj.latestCoinID);
	temp++;
	DSObj.latestCoinID = Integer.toString(temp);	

	minorB.coinID = DSObj.latestCoinID;
	minorB.Source = null;
	minorB.Destination = this;
	minorB.coinsrc_block = null;
	t[count] = minorB;
	
	
        		
	TransactionBlock newblock = new TransactionBlock(t);
	
	DSObj.bChain.InsertBlock_Honest(newblock);

	if(mycoins.get(mycoins.size() - 1).first.equals(minorB.coinID)) return;

	mycoins.add(new Pair<String,TransactionBlock>(minorB.coinID,newblock));
  }  

  public void MineCoin(DSCoin_Malicious DSObj) {
	int count = 0;
	Transaction[] t = new Transaction[DSObj.bChain.tr_count]; 
	HashMap<String,Integer> m = new HashMap<String,Integer>();
	TransactionBlock lastBlock = DSObj.bChain.FindLongestValidChain();
	try{
		while(count != DSObj.bChain.tr_count - 1 && (DSObj.pendingTransactions.numTransactions > 0)){
			Transaction newtr = DSObj.pendingTransactions.RemoveTransaction();
			String obj = new String();
			obj = newtr.coinID;
			if(!lastBlock.checkTransaction(newtr)) continue;
			if(m.get(obj) == null){
				m.put(obj,1);
			}
			else continue;
			t[count] = newtr;
			count++;
		}
	}catch(EmptyQueueException e){}
	Transaction minorB = new Transaction();

	int temp = Integer.parseInt(DSObj.latestCoinID);
	temp++;
	DSObj.latestCoinID = Integer.toString(temp);

	minorB.coinID = DSObj.latestCoinID;
	minorB.Source = null;
	minorB.Destination = this;
	minorB.coinsrc_block = null;
	t[count] = minorB;
	
	
        		
	TransactionBlock newblock = new TransactionBlock(t);
	
	DSObj.bChain.InsertBlock_Malicious(newblock);
	
	if(mycoins.get(mycoins.size() - 1).first.equals(minorB.coinID)) return;

	mycoins.add(new Pair<String,TransactionBlock>(minorB.coinID,newblock));
  }  
}
