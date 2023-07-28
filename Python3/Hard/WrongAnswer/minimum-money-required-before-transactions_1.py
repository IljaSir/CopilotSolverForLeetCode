class Solution:
    def minimumMoney(self, transactions: List[List[int]]) -> int:
        
        return sum([cost for cost, _ in sorted(transactions, key=lambda x: x[0] - x[1])])