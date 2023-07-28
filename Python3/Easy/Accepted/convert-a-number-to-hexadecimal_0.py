class Solution:
    def toHex(self, num: int) -> str:
        
        if num == 0:
            return "0"
        if num < 0:
            num = 2**32 + num
        result = ""
        while num > 0:
            remainder = num % 16
            if remainder > 9:
                result = chr(ord('a') + remainder - 10) + result
            else:
                result = str(remainder) + result
            num //= 16
        return result