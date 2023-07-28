class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        
        def longest_repeating(s):
            res = 0
            for i, c in enumerate(s):
                l = r = i
                while l - 1 >= 0 and s[l - 1] == c:
                    l -= 1
                while r + 1 < len(s) and s[r + 1] == c:
                    r += 1
                res = max(res, r - l + 1)
            return res
        res = []
        for i, c in zip(queryIndices, queryCharacters):
            s = s[:i] + c + s[i + 1:]
            res.append(longest_repeating(s))
        return res