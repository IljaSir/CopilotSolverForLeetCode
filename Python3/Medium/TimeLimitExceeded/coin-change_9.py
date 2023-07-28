class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if amount == 0:
            return 0
        if len(coins) == 0:
            return -1
        coins.sort(reverse=True)
        self.ans = float('inf')
        def dfs(coins, amount, count):
            if amount == 0:
                self.ans = min(self.ans, count)
                return
            if len(coins) == 0:
                return
            for i in range(amount // coins[0], -1, -1):
                if count + i >= self.ans:
                    break
                dfs(coins[1:], amount - i * coins[0], count + i)
        dfs(coins, amount, 0)
        return self.ans if self.ans != float('inf') else -1