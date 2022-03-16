package DSCoinPackage;

import HelperClasses.*;
import java.util.*;
public class Moderator
 {
  public void initializeDSCoin(DSCoin_Honest DSObj, int coinCount) {
	Members obj = new Members();
	obj.UID = "Moderator";
	int len = DSObj.memberlist.length;
	int idx = 0;
	//Distribution of coins in round-robin fashion.
	int k;
  	for(k = 100000;k<100000+coinCount;k++){
		Transaction newtr = new Transaction();
		newtr.coinID = Integer.toString(k);
		newtr.Destination = DSObj.memberlist[idx%len];
		newtr.Source = obj;
		newtr.coinsrc_block = null;
		idx++;
		DSObj.pendingTransactions.AddTransactions(newtr);
	}
	DSObj.latestCoinID = Integer.toString(k-1);

	int temp = coinCount;
	try{
		while(temp>0){
			Transaction[] t = new Transaction[DSObj.bChain.tr_count];
			for(int i = 0;i<DSObj.bChain.tr_count;i++){
				Transaction temp1 = DSObj.pendingTransactions.RemoveTransaction();
				t[i] = temp1;
			}
			TransactionBlock newblock = new TransactionBlock(t);
			for(int i = 0;i<DSObj.bChain.tr_count;i++){
				t[i].Destination.mycoins.add(new Pair<String,TransactionBlock>(t[i].coinID,newblock));
			}
			DSObj.bChain.InsertBlock_Honest(newblock);
			temp-= DSObj.bChain.tr_count;
		}
		
	}catch(Exception e){System.out.println(e);}
  }
    
  public void initializeDSCoin(DSCoin_Malicious DSObj, int coinCount) {
	Members obj = new Members();
	obj.UID = "Moderator";
	int len = DSObj.memberlist.length;
	int idx = 0;

	//Distribution of coins in round-robin fashion.
	int k;
  	for(k = 100000;k<100000+coinCount;k++){
		Transaction newtr = new Transaction();
		newtr.coinID = Integer.toString(k);
		newtr.Destination = DSObj.memberlist[idx%len];
		newtr.Source = obj;
		newtr.coinsrc_block = null;
		idx++;
		DSObj.pendingTransactions.AddTransactions(newtr);
	}
	DSObj.latestCoinID = Integer.toString(k-1);
	int temp = coinCount;
	try{
		while(temp>0){
			Transaction[] t = new Transaction[DSObj.bChain.tr_count];
			for(int i = 0;i<DSObj.bChain.tr_count;i++){
				Transaction temp1 = DSObj.pendingTransactions.RemoveTransaction();
				t[i] = temp1;
			}
			TransactionBlock newblock = new TransactionBlock(t);
			for(int i = 0;i<DSObj.bChain.tr_count;i++){
				t[i].Destination.mycoins.add(new Pair<String,TransactionBlock>(t[i].coinID,newblock));
			}
			DSObj.bChain.InsertBlock_Malicious(newblock);
			temp-= DSObj.bChain.tr_count;
		}
	}catch(EmptyQueueException e){}
  }
}
