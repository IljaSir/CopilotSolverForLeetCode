class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        if stones[1] != 1:
            return False
        n = len(stones)
        dp = [set() for _ in range(n)]
        dp[1].add(1)
        for i in range(1, n):
            for j in range(i):
                k = stones[i] - stones[j]
                if k in dp[j]:
                    dp[i].add(k)
                    if k - 1 > 0:
                        dp[i].add(k - 1)
                    dp[i].add(k + 1)
        return len(dp[-1]) > 0