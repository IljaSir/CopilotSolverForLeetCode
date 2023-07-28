class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        if c == 0:
            return True
        for i in range(1, int(c ** 0.5) + 1):
            if c - i ** 2 >= 0 and int((c - i ** 2) ** 0.5) ** 2 == c - i ** 2:
                return True
        return False