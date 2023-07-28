class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        ans = []
        for i in range(len(s)):
            if s[i] == c:
                ans.append(0)
            else:
                ans.append(min(abs(i - j) for j in range(len(s)) if s[j] == c))
        return ans