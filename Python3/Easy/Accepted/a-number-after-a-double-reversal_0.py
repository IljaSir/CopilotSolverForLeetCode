class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        
        num1 = int(str(num)[::-1])
        num2 = int(str(num1)[::-1])
        return num == num2