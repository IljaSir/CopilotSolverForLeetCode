class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        for i in range(int(c**0.5)+1):
            if int((c-i**2)**0.5)**2+i**2 == c:
                return True
        return False