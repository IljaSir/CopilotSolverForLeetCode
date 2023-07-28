class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        
        max_wealth = 0
        for customer in accounts:
            wealth = 0
            for bank in customer:
                wealth += bank
            if wealth > max_wealth:
                max_wealth = wealth
        return max_wealth