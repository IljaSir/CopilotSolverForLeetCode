class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if len(s) < len(t):
            return ""
        from collections import Counter
        counter = Counter(t)
        left = 0
        right = 0
        min_len = float('inf')
        min_left = 0
        min_right = 0
        while right < len(s):
            if s[right] in counter:
                counter[s[right]] -= 1
            while all([v <= 0 for v in counter.values()]):
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_left = left
                    min_right = right
                if s[left] in counter:
                    counter[s[left]] += 1
                left += 1
            right += 1
        if min_len == float('inf'):
            return ""
        return s[min_left:min_right+1]