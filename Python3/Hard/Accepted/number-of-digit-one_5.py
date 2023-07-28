class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n < 1:
            return 0
        if n < 10:
            return 1
        div = 1
        while n // div >= 10:
            div *= 10
        high = n // div
        low = n % div
        if high == 1:
            return self.countDigitOne(div - 1) + self.countDigitOne(low) + low + 1
        else:
            return self.countDigitOne(div - 1) * high + self.countDigitOne(low) + div