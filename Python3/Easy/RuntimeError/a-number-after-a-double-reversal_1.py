class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        
        reversed1 = self.reverse(num)
        reversed2 = self.reverse(reversed1)
        return num == reversed2