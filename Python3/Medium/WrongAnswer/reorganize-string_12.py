class Solution:
    def reorganizeString(self, s: str) -> str:
        
        if not s:
            return ''
        if len(s) == 1:
            return s
        s = sorted(s)
        c = 0
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                c += 1
        if c * 2 >= len(s):
            return ''
        res = [None] * len(s)
        res[::2] = s[len(s)//2:]
        res[1::2] = s[:len(s)//2]
        return ''.join(res)