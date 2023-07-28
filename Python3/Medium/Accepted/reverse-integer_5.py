class Solution:
    def reverse(self, x: int) -> int:
        
        if x >= 0:
            n = int(str(x)[::-1])
        else:
            n = -int(str(-x)[::-1])
        return n if -2**31 <= n <= 2**31-1 else 0