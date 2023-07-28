class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        result = []
        for i in range(len(s)):
            if s[i] == c:
                result.append(0)
            else:
                result.append(min([abs(i - j) for j in range(len(s)) if s[j] == c]))
        return result