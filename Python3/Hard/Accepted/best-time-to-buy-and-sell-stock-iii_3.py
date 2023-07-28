class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        n = len(prices)
        if n <= 1:
            return 0
        f = [0] * n
        g = [0] * n
        min_price = prices[0]
        for i in range(1, n):
            min_price = min(min_price, prices[i])
            f[i] = max(f[i - 1], prices[i] - min_price)
        max_price = prices[n - 1]
        for i in range(n - 2, -1, -1):
            max_price = max(max_price, prices[i])
            g[i] = max(g[i + 1], max_price - prices[i])
        ans = 0
        for i in range(n):
            ans = max(ans, f[i] + g[i])
        return ans