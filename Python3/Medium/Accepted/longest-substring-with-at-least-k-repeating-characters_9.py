class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        
        if len(s) < k:
            return 0
        if k <= 1:
            return len(s)
        c = collections.Counter(s)
        d = [i for i in c if c[i] < k]
        if not d:
            return len(s)
        return max(self.longestSubstring(t, k) for t in s.split(d[0]))