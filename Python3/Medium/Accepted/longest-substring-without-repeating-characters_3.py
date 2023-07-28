class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if not s:
            return 0
        start = 0
        max_len = 0
        char_map = {}
        for i, c in enumerate(s):
            if c in char_map and char_map[c] >= start:
                start = char_map[c] + 1
            char_map[c] = i
            max_len = max(max_len, i - start + 1)
        return max_len