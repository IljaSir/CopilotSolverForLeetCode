class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        for i in range(int(math.sqrt(c))+1):
            j = math.sqrt(c - i**2)
            if j == int(j):
                return True
        return False