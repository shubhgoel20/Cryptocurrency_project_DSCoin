# Cryptocurrency_project_DSCoin
Java based implementation of a nearly complete, buyer-seller-miner based cyrptocurrency-DSCoin.


## Introduction
- Every *coin* is a six digit unique number.
- Every *transaction* has the following information:
  -the coin being transferred
  - the source (that is, the person spending this coin)
  - the destination (that is, the person receiving this coin)
  - some information to indicate when the source received this coin from someone.
For simplicity, I have assumed that every transaction consists of exactly one coin.
- A *transaction-block* consists of a set of transactions. Let **tr-count** denote the number of transactions
  per block.
- A blockchain is an authenticated linked list of transaction-blocks.
- *Pending transactions* and *transaction-queue*: All the transactions in the transaction-block are processed
transactions. Additionally, I have a transaction-queue which contains pending transactions. Every
new transaction is first added to the transaction-queue, and later moved to a transaction-block (and
thus added to the blockchain).

## DSCoin
### DSCoin_Honest
1. Buyer adds transaction to the transaction-queue.
2. Miner collects many such transactions, mines a transaction-block and adds the block to the blockchain.
3. Once the block is added to the blockchain, the buyer checks that his/her transaction is present in
the last block. If so, the buyer computes a ‘proof of membership’ of this transaction in one of the
transaction block, and sends it to the seller.
4. Finally, the seller verifies this ‘proof of membership’.

#### Initialising a Coin-Send
Every buyer/seller has a **UID**. The buyer creates a new
transaction t, where the coinID, Source, Destination and coinsrc block are set appropriately. After this,
the buyer adds this transaction to the transaction queue. Additionally, the buyer also maintains his/her own
queue of pending transactions (called in process trans), and the buyer adds the transaction to this queue.

#### Mining a Transaction-Block
A transaction-block consists of the following attributes:
- **tr-count:** the number of transactions in the block. I will assume that this is a power of 2.
- **trarray:** an array of transactions.
- **trsummary:** a 64-character summary of the entire transaction-array. This is computed using a Merkle
tree on the trarray.
- **Tree:** the Merkle tree on trarray.
- **nonce:** a 10-digit string that is used to compute the dgst.
- **dgst:** a 64-character string, obtained by computing the CRF on previous digest, transaction-summary
and a 10-digit string called nonce, separated by #. The nonce must be such that the first four characters
of dgst are all zeroes.
The miner collects **tr-count - 1** number of valid transactions from the **TransactionQueue**. The miner
also gets a reward for mining this block. This reward, in my cryptocurrency, is one coin. The miner then creates a transaction for this reward.
Therefore, the miner has **tr-count** number of transactions, which are included in the transaction block as follows:
1. Add the transactions to the transaction array **trarray**.
2. Compute Merkle tree on the transaction array. Every node in the Merkle tree has a string attribute
called **val**. For a leaf node corresponding to transaction, the val is simply CRF applied on a concatenation of the coin-id, source id, destination id and dgst of the coinsrc block corresponding to this transaction (separated by #).For any intermediate node, it is computed by applying the CRF on the concatenation of left child’s val and right child’s val (separated by #).
3. Find a 10-digit string **nonce** such that CRF applied on the previous block’s digest,the Merkle tree’s
root’s val (i.e., also the current block’s **trsummary**) and nonce (separated by #) outputs a string with
first four characters being 0. This output is the new block’s digest.

#### Verification of Transaction by the Seller
The validity of a transaction is verified by the seller using a sibling-coupled-path-to-root,the dgst of b<sub>0</sub>.previous, the
(dgst<sub>i</sub>, nonce<sub>i</sub>, trsummary<sub>i</sub>) pairs for each of the blocks b<sub>i</sub>, i ∈ [0, k]. Here b<sub>0</sub> is the block in which the transaction is present and b<sub>1</sub>, . . . , b<sub>k</sub> are the blocks in the blockchain after b<sub>0</sub>.

### DSCoin_Malicious: Handling Malicious Miners
- The blockchain is generalized – instead of having a
linked list, I have a tree-like structure, where I store all leaf blocks of the tree, and for each block, I
have a pointer to the previous block.

- I define a transaction block to be *valid* if the dgst is correct, all transactions in the block are valid and the Merkle tree is computed properly.  The *longest valid chain* is defined to be the longest sequence of blocks, starting with the first block, consisting of only valid blocks. If an honest miner is mining a
new block, then the miner finds the longest valid chain, and attaches the new transaction to this valid chain.
