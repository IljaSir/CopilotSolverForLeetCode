class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        
        # Get the transactions
        transactions = [self.get_transaction(transaction) for transaction in transactions]
        # Get the invalid transactions
        invalid_transactions = []
        for i, transaction in enumerate(transactions):
            if self.is_transaction_invalid(transaction, transactions[i+1:]):
                invalid_transactions.append(transaction)
        # Return the invalid transactions
        return invalid_transactions