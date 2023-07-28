class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        
        if s[-1] == '1':
            return False
        if len(s) == 1:
            return True
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(1, len(s)):
            if s[i] == '1':
                continue
            if i - minJump >= 0:
                dp[i] = dp[i - minJump]
            if dp[i] == False and i - maxJump - 1 >= 0:
                dp[i] = dp[i - maxJump - 1]
            if dp[i] == False and i - maxJump - 1 < 0:
                dp[i] = dp[0]
            if i - maxJump - 1 >= 0:
                dp[i] = dp[i] or dp[i - maxJump - 1]
            dp[i] = dp[i] or dp[i - 1]
        return dp[-2]