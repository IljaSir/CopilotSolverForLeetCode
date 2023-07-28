class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        if len(s) == 1:
            return 1
        l = 0
        r = 1
        max_count = 1
        max_char = s[0]
        char_count = {s[0]: 1}
        while r < len(s):
            char_count[s[r]] = char_count.get(s[r], 0) + 1
            if char_count[s[r]] > max_count:
                max_count = char_count[s[r]]
                max_char = s[r]
            if r - l + 1 - max_count > k:
                char_count[s[l]] -= 1
                l += 1
            r += 1
        return r - l