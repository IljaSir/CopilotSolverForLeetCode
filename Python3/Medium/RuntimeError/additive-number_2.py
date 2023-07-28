class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        return self.isAdditiveNumberHelper(num, 0, 0, 0, 0)