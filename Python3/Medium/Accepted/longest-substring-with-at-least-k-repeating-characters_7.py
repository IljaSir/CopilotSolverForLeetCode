class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        
        counts = collections.Counter(s)
        for c, count in counts.items():
            if count < k:
                return max(self.longestSubstring(t, k) for t in s.split(c))
        return len(s)