class Solution:
    def smallestNumber(self, num: int) -> int:
        
        if num == 0:
            return 0
        if num < 0:
            return -self.smallestNumber(-num)
        digits = [int(d) for d in str(num)]
        digits.sort()
        return int(''.join(str(d) for d in digits))