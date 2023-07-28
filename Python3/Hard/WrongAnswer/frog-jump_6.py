class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        # stones = sorted(stones)
        n = len(stones)
        dp = [[0]*n for _ in range(n)]
        dp[0][0] = 1
        for i in range(1, n):
            for j in range(i):
                k = stones[i] - stones[j]
                if k > j + 1:
                    break
                dp[i][k] = dp[j][k-1] or dp[j][k] or dp[j][k+1]
                if i == n - 1 and dp[i][k]:
                    return True
        return False