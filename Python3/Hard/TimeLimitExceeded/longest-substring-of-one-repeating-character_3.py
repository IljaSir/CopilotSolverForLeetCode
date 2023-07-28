class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        
        def get_longest_repeating(s: str) -> int:
            if not s:
                return 0
            l = 0
            r = 0
            n = len(s)
            c = s[0]
            res = 0
            while r < n:
                if s[r] == c:
                    res = max(res, r-l+1)
                    r += 1
                else:
                    l = r
                    c = s[r]
            return res
        res = []
        for i, (c, idx) in enumerate(zip(queryCharacters, queryIndices)):
            s = s[:idx] + c + s[idx+1:]
            res.append(get_longest_repeating(s))
        return res