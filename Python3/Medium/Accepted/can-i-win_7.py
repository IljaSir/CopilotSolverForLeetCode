class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if desiredTotal == 0:
            return True
        if desiredTotal > (maxChoosableInteger * (maxChoosableInteger + 1)) // 2:
            return False
        if maxChoosableInteger == 1:
            return True
        dp = {}
        def dfs(desiredTotal, state):
            if state in dp:
                return dp[state]
            if desiredTotal <= 0:
                return False
            for i in range(maxChoosableInteger):
                if state & (1 << i) == 0:
                    if not dfs(desiredTotal - (i + 1), state | (1 << i)):
                        dp[state] = True
                        return True
            dp[state] = False
            return False
        return dfs(desiredTotal, 0)