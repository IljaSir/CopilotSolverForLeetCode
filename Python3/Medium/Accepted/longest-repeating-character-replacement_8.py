class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        # sliding window
        # 1. keep track of most freq char
        # 2. if len(window) - most_freq_char > k, then we need to move the window
        # 3. return max(len(window))
        most_freq = 0
        l = 0
        d = {}
        for r in range(len(s)):
            d[s[r]] = d.get(s[r], 0) + 1
            most_freq = max(most_freq, d[s[r]])
            if r - l + 1 - most_freq > k:
                d[s[l]] -= 1
                l += 1
        return len(s) - l