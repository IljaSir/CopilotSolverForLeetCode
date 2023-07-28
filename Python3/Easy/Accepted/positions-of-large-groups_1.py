class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        
        if not s:
            return []
        start, end = 0, 0
        res = []
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                end = i
            else:
                if end - start >= 2:
                    res.append([start, end])
                start = i
                end = i
        if end - start >= 2:
            res.append([start, end])
        return res