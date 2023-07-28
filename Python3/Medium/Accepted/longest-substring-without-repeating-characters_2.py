class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if not s:
            return 0
        if len(s) == 1:
            return 1
        start = 0
        end = 1
        max_len = 0
        while end < len(s):
            if s[end] not in s[start:end]:
                end += 1
                max_len = max(max_len, end - start)
            else:
                start += 1
        return max_len