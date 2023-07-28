class Solution:
    def toHex(self, num: int) -> str:
        
        if num == 0:
            return "0"
        if num < 0:
            num += 2 ** 32
        res = ""
        while num:
            num, rest = divmod(num, 16)
            res = "0123456789abcdef"[rest] + res
        return res