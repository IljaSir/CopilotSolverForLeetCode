class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if len(s) < len(t): return ""
        if len(s) == len(t): return s if s == t else ""
        if len(t) == 1: return t if t in s else ""
        cnt = dict()
        for c in t:
            if c in cnt: cnt[c] += 1
            else: cnt[c] = 1
        n = len(cnt)
        i = j = 0
        res = (0, float('inf'))
        while j < len(s):
            if s[j] in cnt:
                cnt[s[j]] -= 1
                if cnt[s[j]] == 0: n -= 1
            while n == 0:
                if j - i < res[1] - res[0]: res = (i, j)
                if s[i] in cnt:
                    cnt[s[i]] += 1
                    if cnt[s[i]] > 0: n += 1
                i += 1
            j += 1
        return s[res[0]:res[1]+1] if res[1] < float('inf') else ""