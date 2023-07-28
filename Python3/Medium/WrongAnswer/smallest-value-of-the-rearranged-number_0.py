class Solution:
    def smallestNumber(self, num: int) -> int:
        
        if num == 0:
            return 0
        if num < 0:
            return -self.smallestNumber(-num)
        digits = []
        while num:
            digits.append(num % 10)
            num //= 10
        digits.sort()
        return int(''.join(map(str, digits)))