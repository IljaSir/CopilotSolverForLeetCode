class Solution:
    def sortString(self, s: str) -> str:
        
        s = list(s)
        s.sort()
        result = []
        while s:
            for c in set(s):
                result.append(c)
                s.remove(c)
            for c in set(s)[::-1]:
                result.append(c)
                s.remove(c)
        return "".join(result)