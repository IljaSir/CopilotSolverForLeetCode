class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        i = 0
        j = int(c**0.5)
        while i<=j:
            if i*i + j*j == c:
                return True
            elif i*i + j*j < c:
                i +=1
            else:
                j -=1
        return False