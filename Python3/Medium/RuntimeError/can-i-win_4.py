class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if desiredTotal == 0:
            return True
        if (maxChoosableInteger + 1) * maxChoosableInteger // 2 < desiredTotal:
            return False
        self.memo = {}
        return self.dfs(desiredTotal, maxChoosableInteger, 0)