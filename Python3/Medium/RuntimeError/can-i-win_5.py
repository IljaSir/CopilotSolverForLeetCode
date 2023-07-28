class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if desiredTotal <= maxChoosableInteger:
            return True
        if (1+maxChoosableInteger)*maxChoosableInteger//2 < desiredTotal:
            return False
        self.memo = {}
        return self.helper(range(1, maxChoosableInteger+1), desiredTotal)