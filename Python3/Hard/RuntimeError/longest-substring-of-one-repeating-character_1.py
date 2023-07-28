class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        
        res = []
        for i in range(len(queryCharacters)):
            s = s[:queryIndices[i]] + queryCharacters[i] + s[queryIndices[i]+1:]
            # print(s)
            res.append(self.longestSubstring(s))
        return res