class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        seen = set()
        start = 0
        max_len = 0
        for i, c in enumerate(s):
            if c in seen:
                while s[start] != c:
                    seen.remove(s[start])
                    start += 1
                start += 1
            else:
                seen.add(c)
                max_len = max(max_len, i - start + 1)
        return max_len