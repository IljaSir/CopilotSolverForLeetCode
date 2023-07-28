class Solution:
    def reverse(self, x: int) -> int:
        
        # max_int = 2**31 - 1
        # min_int = -2**31
        # if x >= max_int or x <= min_int:
        #     return 0
        if x == 0:
            return 0
        if x < 0:
            return -self.reverse(-x)
        else:
            x = str(x)
            x = x[::-1]
            x = int(x)
            if x >= 2**31 - 1 or x <= -2**31:
                return 0
            else:
                return x