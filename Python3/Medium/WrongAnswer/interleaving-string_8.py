class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        
        if len(s1) + len(s2) != len(s3):
            return False
        dp = [True] + [False] * len(s2)
        for i in range(len(s1) + 1):
            for j in range(len(s2) + 1):
                if i > 0 and s1[i-1] == s3[i+j-1]:
                    dp[j] = dp[j] or dp[j]
                if j > 0 and s2[j-1] == s3[i+j-1]:
                    dp[j] = dp[j] or dp[j-1]
        return dp[-1]