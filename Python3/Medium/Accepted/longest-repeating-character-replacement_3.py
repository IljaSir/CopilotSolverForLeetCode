class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        n = len(s)
        d = {}
        for i in range(26):
            d[chr(i+65)] = 0
        max_len = 0
        start = 0
        for end in range(n):
            d[s[end]] += 1
            max_len = max(max_len, d[s[end]])
            if end - start + 1 - max_len > k:
                d[s[start]] -= 1
                start += 1
        return n - start