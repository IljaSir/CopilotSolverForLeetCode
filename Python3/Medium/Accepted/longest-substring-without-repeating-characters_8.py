class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # sliding window
        if not s:
            return 0
        if len(s) == 1:
            return 1
        left, right = 0, 1
        s_set = set()
        s_set.add(s[left])
        max_len = 1
        while right < len(s):
            if s[right] in s_set:
                while s[left] != s[right]:
                    s_set.remove(s[left])
                    left += 1
                left += 1
            else:
                s_set.add(s[right])
                max_len = max(max_len, right - left + 1)
            right += 1
        return max_len