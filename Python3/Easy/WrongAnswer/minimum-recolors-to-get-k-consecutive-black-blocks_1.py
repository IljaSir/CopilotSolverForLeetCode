class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        
        
        n = len(blocks)
        dp = [n] * n
        dp[0] = 0 if blocks[0] == 'B' else 1
        for i in range(1, n):
            if blocks[i] == 'B':
                dp[i] = dp[i-1]
            else:
                dp[i] = dp[i-1] + 1
            if i >= k:
                if blocks[i-k] == 'B':
                    dp[i] = min(dp[i], dp[i-k] + 1)
                else:
                    dp[i] = min(dp[i], dp[i-k])
        return dp[n-1]