class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        start = 0
        end = 1
        max_len = 1
        while end < len(s):
            if s[end] in s[start:end]:
                start = s[start:end].index(s[end]) + start + 1
            end += 1
            max_len = max(max_len, end - start)
        return max_len