class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        res = []
        for i in range(len(s)):
            if s[i] == c:
                res.append(0)
            else:
                res.append(min([abs(i - j) for j in range(len(s)) if s[j] == c]))
        return res