class Solution:
    def reverse(self, x: int) -> int:
        
        if x == 0:
            return 0
        
        x_str = str(x)
        x_str = x_str[::-1]
        x_str = x_str.rstrip('0')
        if x_str[-1] == '-':
            x_str = '-' + x_str[:-1]
        x_int = int(x_str)
        if x_int > 2**31 or x_int < -2**31:
            return 0
        return x_int