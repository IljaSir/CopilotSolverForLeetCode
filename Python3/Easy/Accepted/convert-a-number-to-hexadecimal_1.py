class Solution:
    def toHex(self, num: int) -> str:
        
        if num == 0:
            return "0"
        if num < 0:
            num += 2**32
        hex_digits = "0123456789abcdef"
        result = ""
        while num > 0:
            result = hex_digits[num % 16] + result
            num //= 16
        return result