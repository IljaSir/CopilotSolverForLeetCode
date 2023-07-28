class Solution:
    def countOperations(self, num1: int, num2: int) -> int:
        
        if num1 == num2:
            return 1
        if num1 > num2:
            num1, num2 = num2, num1
        if num1 == 0:
            return 0
        if num1 == 1:
            return num2 - 1
        return num2 // num1 + self.countOperations(num2 % num1, num1)