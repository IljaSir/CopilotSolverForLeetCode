class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if desiredTotal == 0: return True
        if (1 + maxChoosableInteger) * maxChoosableInteger // 2 < desiredTotal:
            return False
        self.memo = {}
        self.maxChoosableInteger = maxChoosableInteger
        return self.dfs(desiredTotal, 0)