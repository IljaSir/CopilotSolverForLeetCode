class Solution:
    def toHex(self, num: int) -> str:
        
        if num == 0:
            return "0"
        if num < 0:
            num = 2**32 + num
        hex_map = "0123456789abcdef"
        res = []
        while num > 0:
            res.append(hex_map[num % 16])
            num //= 16
        return "".join(res[::-1])