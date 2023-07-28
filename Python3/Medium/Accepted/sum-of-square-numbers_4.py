class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        for i in range(int(c**0.5)+1):
            j = (c-i**2)**0.5
            if j == int(j):
                return True
        return False