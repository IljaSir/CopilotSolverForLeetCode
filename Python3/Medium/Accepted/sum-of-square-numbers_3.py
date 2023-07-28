class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        for i in range(int(c**0.5)+1):
            if int((c-i*i)**0.5)**2 == c-i*i:
                return True
        return False