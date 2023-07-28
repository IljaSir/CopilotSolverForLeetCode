class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        
        price.sort()
        n = len(price)
        dp = [[0] * n for _ in range(k)]
        for i in range(n):
            dp[0][i] = price[i] * i - price[i] * (n - i - 1)
        for i in range(1, k):
            for j in range(i, n):
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - 1] + price[j] * (i - 1) - price[j] * (n - j - 1))
        return max(dp[-1])