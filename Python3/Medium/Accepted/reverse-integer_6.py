class Solution:
    def reverse(self, x: int) -> int:
        
        if x > 2**31-1 or x < -2**31:
            return 0
        if x >= 0:
            x = str(x)
            x = x[::-1]
            x = int(x)
        else:
            x = str(x)
            x = x[1:]
            x = x[::-1]
            x = int(x)
            x = -x
        if x > 2**31-1 or x < -2**31:
            return 0
        return x