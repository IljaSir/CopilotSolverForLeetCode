class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        c_index = []
        for i in range(len(s)):
            if s[i] == c:
                c_index.append(i)
        res = []
        for i in range(len(s)):
            res.append(min([abs(i - j) for j in c_index]))
        return res