class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        
        if len(s) < k:
            return 0
        elif len(set(s)) < k:
            return len(s)
        else:
            for c in set(s):
                if s.count(c) < k:
                    return max(self.longestSubstring(t, k) for t in s.split(c))
            return len(s)