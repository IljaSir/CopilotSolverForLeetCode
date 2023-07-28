class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        
        if k <= 1:
            return len(s)
        if len(s) < k:
            return 0
        count = Counter(s)
        for c in count:
            if count[c] < k:
                return max(self.longestSubstring(t, k) for t in s.split(c))
        return len(s)