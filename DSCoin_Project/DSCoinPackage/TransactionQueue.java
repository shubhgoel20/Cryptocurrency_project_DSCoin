package DSCoinPackage;

public class TransactionQueue {

  public Transaction firstTransaction;
  public Transaction lastTransaction;
  public int numTransactions = 0;

  public void AddTransactions (Transaction transaction) {
	if(this.firstTransaction == null){
		this.firstTransaction = new Transaction();
		this.firstTransaction = transaction;
		this.lastTransaction = this.firstTransaction;
		this.numTransactions = 1;
	}
	else{
		Transaction temp = new Transaction();
		temp = transaction;
		this.lastTransaction.next = temp;
		temp.previous = this.lastTransaction;
		this.lastTransaction = temp;
		this.numTransactions+=1;
	}
  }
  
  public Transaction RemoveTransaction () throws EmptyQueueException {
  	if(this.numTransactions <= 0){
		throw new EmptyQueueException();
	}
	this.numTransactions-=1;
	Transaction temp = this.firstTransaction;
	this.firstTransaction = temp.next;
	temp.next = null;
	if(this.firstTransaction != null) this.firstTransaction.previous = null;
	else this.lastTransaction = null;
	return temp;  
  }

  public int size() {
    return this.numTransactions;
  }
}
