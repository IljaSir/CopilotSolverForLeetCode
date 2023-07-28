class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        res = []
        for i, c in enumerate(s):
            if c not in res:
                while res and res[-1] > c and s.find(res[-1], i) != -1:
                    res.pop()
                res.append(c)
        return ''.join(res)