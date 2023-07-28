class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        from collections import Counter
        t = Counter(t)
        n = len(s)
        i = 0
        j = 0
        min_len = float('inf')
        min_i = 0
        min_j = 0
        while j < n:
            if s[j] in t:
                t[s[j]] -= 1
                if t[s[j]] == 0:
                    del t[s[j]]
            if not t:
                while i <= j:
                    if s[i] in t or t[s[i]] < 0:
                        t[s[i]] += 1
                    if s[i] in t:
                        break
                    i += 1
                if j - i + 1 < min_len:
                    min_len = j - i + 1
                    min_i = i
                    min_j = j
            j += 1
        return s[min_i: min_j + 1] if min_len != float('inf') else ""