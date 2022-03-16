package DSCoinPackage;
import java.util.*;
import HelperClasses.*;
import DSCoinPackage.*;

public class Malicious_Driver {

    public static void main(String[] args){

        try {
            DSCoin_Malicious obj = new DSCoin_Malicious();
            Moderator mod = new Moderator();
            obj.pendingTransactions = new TransactionQueue();
            obj.bChain = new BlockChain_Malicious();
            obj.bChain.lastBlocksList = new TransactionBlock[100];
            Boolean correct = true;
            obj.memberlist = new Members[10];
            for (int i = 0; i < 10; i ++){
            obj.memberlist[i] = new Members();
            obj.memberlist[i].UID = "Member " + Integer.toString(i);
            obj.memberlist[i].mycoins = new ArrayList<Pair<String,TransactionBlock>>();
            obj.memberlist[i].in_process_trans = new Transaction[100];
        }
        obj.bChain.tr_count = 32;
        mod.initializeDSCoin(obj,128);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[2].MineCoin(obj);
                    finalise(obj, obj.bChain.lastBlocksList[0]);
                        Transaction tr[] = new Transaction[32];
                        
                        Transaction tobj = new Transaction();
                        tobj.coinID = "100002";
                    tobj.Source = obj.memberlist[2];
                    tobj.Destination = obj.memberlist[7];
                    tobj.coinsrc_block = obj.bChain.lastBlocksList[0].previous.previous.previous.previous;
                    tr[0] = tobj;
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[7].UID,obj);
                    for(int i=1;i<32;i++){
                        tr[i] = obj.pendingTransactions.RemoveTransaction();
                    }
                    TransactionBlock tB = new TransactionBlock(tr);
                    tB.previous = obj.bChain.lastBlocksList[0];
                    obj.bChain.InsertBlock_Malicious(tB);
                    returncoins(obj,tB);
                        
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[0].UID,obj);
                    Transaction t = obj.pendingTransactions.RemoveTransaction();
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[8].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[8].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[7].MineCoin(obj);
                    finalise(obj, obj.bChain.lastBlocksList[1]);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[8].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[6].MineCoin(obj);
                    finalise(obj, obj.bChain.lastBlocksList[1]);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[9].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[7].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[4].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[8].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[4].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[8].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[2].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[6].initiateCoinsend(obj.memberlist[9].UID,obj);
                    obj.memberlist[0].initiateCoinsend(obj.memberlist[8].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[5].UID,obj);
                    obj.memberlist[2].initiateCoinsend(obj.memberlist[1].UID,obj);
                    obj.memberlist[1].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[3].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[5].initiateCoinsend(obj.memberlist[0].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[3].UID,obj);
                    obj.memberlist[7].initiateCoinsend(obj.memberlist[6].UID,obj);
                    obj.memberlist[0].MineCoin(obj);
                    finalise(obj, obj.bChain.lastBlocksList[1]);
                    for (int i = 0 ; i<10;i++){
                        System.out.println(printMember(obj.memberlist[i]));
                    }
                    System.out.println(obj.bChain.lastBlocksList[0].dgst);

                    System.out.println("----------- Mr.X -----------");
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static void finalise(DSCoin_Malicious DSObj,TransactionBlock tB){
       for(int j = 0; j<tB.trarray.length; j++) {
           Transaction tobj = tB.trarray[j];
           for(int i = 0; i < DSObj.memberlist.length; i++){
               if(DSObj.memberlist[i].UID == tobj.Destination.UID){
                   DSObj.memberlist[i].mycoins.add(new Pair<String,TransactionBlock>(tobj.coinID, tB));
                   DSObj.memberlist[i].mycoins.sort(new Comparator<Pair<String,TransactionBlock>>() {
                       @Override public int compare(Pair<String,TransactionBlock> p1, Pair<String,TransactionBlock> p2) {
                           if(Integer.parseInt(p1.get_first()) > Integer.parseInt(p2.get_first())) {
                               return 1;
                           }
                           else{
                               return -1;
                           }
                       }
                   });
                   break;
               }
           }
       }        
    }

    public static void returncoins(DSCoin_Malicious DSObj, TransactionBlock tB){
        for(int j = 1; j<tB.trarray.length; j++) {
            Transaction tobj = tB.trarray[j];
            for(int i = 0; i < DSObj.memberlist.length; i++){
                if(DSObj.memberlist[i].UID == tobj.Source.UID){
                    DSObj.memberlist[i].mycoins.add(new Pair<String,TransactionBlock>(tobj.coinID, tobj.coinsrc_block));
                    DSObj.memberlist[i].mycoins.sort(new Comparator<Pair<String,TransactionBlock>>() {
                        @Override public int compare(Pair<String,TransactionBlock> p1, Pair<String,TransactionBlock> p2) {
                            if(Integer.parseInt(p1.get_first()) > Integer.parseInt(p2.get_first())) {
                                return 1;
                            }
                            else{
                                return -1;
                            }
                        }
                    });
                    break;
                }
            }
        }
    }

    public static String printMember (Members m){
    	String s = "Member Name : ";
    	s += m.UID + "\n Member Coins \n";
    	for (Pair<String, TransactionBlock> p : m.mycoins){
    	    s += p.first + " ";
    	}
	s += "\n";
    	return s;
    }
}