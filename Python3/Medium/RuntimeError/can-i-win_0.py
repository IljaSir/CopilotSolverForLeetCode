class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if maxChoosableInteger >= desiredTotal:
            return True
        if maxChoosableInteger * (maxChoosableInteger + 1) // 2 < desiredTotal:
            return False
        self.memo = {}
        return self.dfs(list(range(1, maxChoosableInteger + 1)), desiredTotal)