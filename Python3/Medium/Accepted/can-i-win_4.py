class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if maxChoosableInteger >= desiredTotal:
            return True
        if (1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal:
            return False
        dp = {}
        def helper(used, remain):
            if used in dp:
                return dp[used]
            for i in range(maxChoosableInteger):
                cur = 1 << i
                if cur & used:
                    continue
                if i + 1 >= remain or not helper(used | cur, remain - i - 1):
                    dp[used] = True
                    return True
            dp[used] = False
            return False
        return helper(0, desiredTotal)