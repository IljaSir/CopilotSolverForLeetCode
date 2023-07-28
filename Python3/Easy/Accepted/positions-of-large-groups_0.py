class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        
        if len(s) < 3:
            return []
        start = 0
        end = 0
        result = []
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                end += 1
            else:
                if end - start + 1 >= 3:
                    result.append([start, end])
                start = i
                end = i
        if end - start + 1 >= 3:
            result.append([start, end])
        return result