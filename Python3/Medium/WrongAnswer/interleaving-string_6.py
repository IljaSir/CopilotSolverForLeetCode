class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        
        if len(s1) + len(s2) != len(s3):
            return False
        if len(s1) > len(s2):
            return self.isInterleave(s2, s1, s3)
        dp = [True] + [False] * len(s1)
        for i in range(len(s3)):
            dp[0] = dp[0] and s3[i] == s2[i]
            for j in range(len(s1)):
                dp[j + 1] = (dp[j + 1] and s3[i] == s1[j]) or (dp[j] and s3[i] == s2[i - j])
        return dp[-1]