class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        
        if len(s) < k:
            return 0
        d = {}
        for c in s:
            if c not in d:
                d[c] = 1
            else:
                d[c] += 1
        for c in d:
            if d[c] < k:
                return max(self.longestSubstring(t, k) for t in s.split(c))
        return len(s)