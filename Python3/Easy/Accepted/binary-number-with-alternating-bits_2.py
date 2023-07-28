class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        
        prev = n % 2
        n >>= 1
        while n > 0:
            curr = n % 2
            if prev == curr:
                return False
            prev = curr
            n >>= 1
        return True