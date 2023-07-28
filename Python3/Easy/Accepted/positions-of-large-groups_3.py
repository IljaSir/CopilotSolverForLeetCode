class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        
        n = len(s)
        if n < 3:
            return []
        start = 0
        end = 1
        result = []
        while end < n:
            if s[start] == s[end]:
                end += 1
            else:
                if end - start >= 3:
                    result.append([start, end - 1])
                start = end
                end += 1
        if end - start >= 3:
            result.append([start, end - 1])
        return result