class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n <= 0:
            return 0
        if n < 10:
            return 1
        if n < 100:
            return 10
        if n < 1000:
            return 100
        if n < 10000:
            return 1000
        if n < 100000:
            return 10000
        if n < 1000000:
            return 100000
        if n < 10000000:
            return 1000000
        if n < 100000000:
            return 10000000
        if n < 1000000000:
            return 100000000
        return 1000000000