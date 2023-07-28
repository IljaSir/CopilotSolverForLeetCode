class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        
        if len(s) < k:
            return 0
        c = Counter(s)
        for i in range(len(s)):
            if c[s[i]] < k:
                return max(self.longestSubstring(s[:i], k), self.longestSubstring(s[i+1:], k))
        return len(s)