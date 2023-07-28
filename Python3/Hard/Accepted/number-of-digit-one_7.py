class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n <= 0:
            return 0
        if n < 10:
            return 1
        d = len(str(n))
        # print(d)
        p = 10**(d-1)
        # print(p)
        first = n // p
        # print(first)
        firstOne = 0
        if first > 1:
            firstOne = p
        elif first == 1:
            firstOne = n - p + 1
        otherOne = first * (d - 1) * (p // 10)
        # print(first, firstOne, otherOne)
        return firstOne + otherOne + self.countDigitOne(n % p)