class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n <= 0:
            return 0
        if n < 10:
            return 1
        digits = len(str(n))
        first = int(str(n)[0])
        if digits == 2:
            if first == 1:
                return 1 + n - 10 + 1
            else:
                return 10
        if digits == 3:
            if first == 1:
                return 1 + 99 + self.countDigitOne(n - 100 + 1)
            else:
                return 100 + 10 * (first - 1) + self.countDigitOne(n - 100 * first)
        if digits == 4:
            if first == 1:
                return 1 + 999 + self.countDigitOne(n - 1000 + 1)
            else:
                return 1000 + 100 * (first - 1) + self.countDigitOne(n - 1000 * first)
        if digits == 5:
            if first == 1:
                return 1 + 9999 + self.countDigitOne(n - 10000 + 1)
            else:
                return 10000 + 1000 * (first - 1) + self.countDigitOne(n - 10000 * first)
        if digits == 6:
            if first == 1:
                return 1 + 99999 + self.countDigitOne(n - 100000 + 1)
            else:
                return 100000 + 10000 * (first - 1) + self.countDigitOne(n - 100000 * first)
        if digits == 7:
            if first == 1:
                return 1 + 999999 + self.countDigitOne(n - 1000000 + 1)
            else:
                return 1000000 + 100000 * (first - 1) + self.countDigitOne(n - 1000000 * first)
        if digits == 8:
            if first == 1:
                return 1 + 9999999 + self.countDigitOne(n - 10000000 + 1)
            else:
                return 10000000 + 1000000 * (first - 1) + self.countDigitOne(n - 10000000 * first)
        if digits == 9:
            if first == 1: