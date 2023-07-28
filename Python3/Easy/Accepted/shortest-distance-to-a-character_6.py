class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        result = [0 for i in range(len(s))]
        c_index = []
        for i in range(len(s)):
            if s[i] == c:
                c_index.append(i)
        for i in range(len(s)):
            if s[i] == c:
                result[i] = 0
            else:
                result[i] = min([abs(i - j) for j in c_index])
        return result