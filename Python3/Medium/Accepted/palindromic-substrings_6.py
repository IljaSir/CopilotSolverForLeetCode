class Solution:
    def countSubstrings(self, s: str) -> int:
        
        def count(s, i, j):
            count = 0
            while i >= 0 and j < len(s) and s[i] == s[j]:
                count += 1
                i -= 1
                j += 1
            return count
        res = 0
        for i in range(len(s)):
            res += count(s, i, i)
            res += count(s, i, i+1)
        return res