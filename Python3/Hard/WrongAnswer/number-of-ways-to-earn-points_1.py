class Solution:
    def waysToReachTarget(self, target: int, types: List[List[int]]) -> int:
        
        dp = [0] * (target + 1)
        dp[0] = 1
        for i in range(len(types)):
            for j in range(types[i][0], target + 1):
                dp[j] = (dp[j] + dp[j - types[i][1]]) % (10 ** 9 + 7)
        return dp[target]