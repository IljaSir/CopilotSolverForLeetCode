class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        
        if len(s) <= 2:
            return []
        i = 0
        j = 1
        res = []
        while j < len(s):
            if s[i] == s[j]:
                j += 1
            else:
                if j - i >= 3:
                    res.append([i, j - 1])
                i = j
                j += 1
        if j - i >= 3:
            res.append([i, j - 1])
        return res