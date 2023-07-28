class Solution:
    def toHex(self, num: int) -> str:
        
        if num == 0:
            return '0'
        if num < 0:
            num += 2**32
        hex_str = ''
        while num > 0:
            num, remainder = divmod(num, 16)
            hex_str = '0123456789abcdef'[remainder] + hex_str
        return hex_str