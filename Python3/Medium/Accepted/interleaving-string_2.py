class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        
        if len(s1) + len(s2) != len(s3):
            return False
        dp = [[False] * (len(s2) + 1) for _ in range(len(s1) + 1)]
        dp[0][0] = True
        for i in range(len(s1)):
            if s1[i] == s3[i]:
                dp[i + 1][0] = True
            else:
                break
        for j in range(len(s2)):
            if s2[j] == s3[j]:
                dp[0][j + 1] = True
            else:
                break
        for i in range(len(s1)):
            for j in range(len(s2)):
                if s1[i] == s3[i + j + 1]:
                    dp[i + 1][j + 1] = dp[i + 1][j + 1] or dp[i][j + 1]
                if s2[j] == s3[i + j + 1]:
                    dp[i + 1][j + 1] = dp[i + 1][j + 1] or dp[i + 1][j]
        return dp[-1][-1]