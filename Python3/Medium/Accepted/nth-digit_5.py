class Solution:
    def findNthDigit(self, n: int) -> int:
        
        # 1. find the range of the number
        # 2. find the exact number
        # 3. find the digit and return
        # 1
        start = 1
        digits = 1
        while n > 9 * start * digits:
            n -= 9 * start * digits
            start *= 10
            digits += 1
        # 2
        num = start + (n - 1) // digits
        # 3
        return int(str(num)[(n - 1) % digits])