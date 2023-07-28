class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        from collections import Counter
        c = Counter()
        max_count = 0
        i = 0
        for j, ch in enumerate(s):
            c[ch] += 1
            max_count = max(max_count, c[ch])
            if j - i + 1 - max_count > k:
                c[s[i]] -= 1
                i += 1
        return j - i + 1