class Solution:
    def toHex(self, num: int) -> str:
        
        if num == 0:
            return "0"
        if num < 0:
            num = 2**32 + num
        result = ""
        while num > 0:
            result = str(hex(num % 16))[2:] + result
            num //= 16
        return result