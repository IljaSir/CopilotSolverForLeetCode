class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        
        if len(s) < 2:
            return len(s)
        else:
            max_len = 1
            current_len = 1
            for i in range(1, len(s)):
                if s[i] > s[i - 1]:
                    current_len += 1
                else:
                    current_len = 1
                max_len = max(max_len, current_len)
            return max_len