class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        
        if desiredTotal == 0:
            return True
        if maxChoosableInteger*(maxChoosableInteger+1)//2 < desiredTotal:
            return False
        return self.helper([True]*maxChoosableInteger, desiredTotal)