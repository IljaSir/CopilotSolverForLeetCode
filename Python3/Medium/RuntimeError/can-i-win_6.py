class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if sum(range(1, maxChoosableInteger + 1)) < desiredTotal:
            return False
        if desiredTotal <= 0:
            return True
        self.memo = {}
        return self.helper(tuple(range(1, maxChoosableInteger + 1)), desiredTotal)