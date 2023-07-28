class Solution:
    def decodeAtIndex(self, s: str, k: int) -> str:
        
        l = 0
        for c in s:
            if c.isdigit():
                l *= int(c)
            else:
                l += 1
        for c in reversed(s):
            k %= l
            if k == 0 and c.isalpha():
                return c
            if c.isdigit():
                l //= int(c)
            else:
                l -= 1