class Solution:
    def reverse(self, x: int) -> int:
        
        if x >= 0:
            if int(str(x)[::-1]) >= 2**31:
                return 0
            else:
                return int(str(x)[::-1])
        else:
            if -int(str(x)[1:][::-1]) <= -2**31:
                return 0
            else:
                return -int(str(x)[1:][::-1])