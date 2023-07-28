class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        
        n = len(s)
        dp = [False] * n
        dp[0] = True
        for i in range(1, n):
            if s[i] == '1':
                continue
            for j in range(i - maxJump, i - minJump + 1):
                if j < 0:
                    continue
                if j == 0 or dp[j]:
                    dp[i] = True
                    break
        return dp[-1]