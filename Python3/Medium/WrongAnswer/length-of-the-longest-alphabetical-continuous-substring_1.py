class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        
        if not s:
            return 0
        max_len = 1
        cur_len = 1
        for i in range(1, len(s)):
            if s[i] > s[i - 1]:
                cur_len += 1
            else:
                max_len = max(max_len, cur_len)
                cur_len = 1
        return max(max_len, cur_len)