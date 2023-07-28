class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        
        return int(str(num)[::-1]) == int(str(int(str(num)[::-1]))[::-1])