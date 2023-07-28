class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        i = 0
        while i * i <= c:
            j = int(math.sqrt(c - i * i))
            if i * i + j * j == c:
                return True
            i += 1
        return False