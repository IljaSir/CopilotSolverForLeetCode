class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        dp = {}
        for i in stones:
            dp[i] = set()
        dp[0].add(0)
        for i in stones:
            for k in dp[i]:
                for step in [k-1, k, k+1]:
                    if step > 0 and i+step in dp:
                        dp[i+step].add(step)
        return len(dp[stones[-1]]) > 0