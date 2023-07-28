class Solution:
    def smallestNumber(self, num: int) -> int:
        
        if num == 0:
            return 0
        if num < 0:
            return -self.smallestNumber(-num)
        digits = []
        while num > 0:
            digits.append(num % 10)
            num //= 10
        digits.sort()
        res = 0
        for i in range(len(digits)):
            res += digits[i] * (10 ** i)
        return res