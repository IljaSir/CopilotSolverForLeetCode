class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if len(s) < len(t):
            return ""
        if len(s) == len(t):
            return s if s == t else ""

        from collections import Counter
        t = Counter(t)
        t_count = len(t)
        s_count = 0
        s = Counter(s)
        for c in t:
            if c not in s:
                return ""
            s_count += 1 if s[c] >= t[c] else 0

        if s_count == t_count:
            return s.most_common()[-1][0] * len(t)
        
        l, r = 0, 0
        ans = ""
        while r < len(s):
            if s_count == t_count:
                if not ans or len(ans) > r - l:
                    ans = s.most_common()[-1][0] * (r - l)
                if s[s[r]] == t[s[r]]:
                    s_count -= 1
                s[s[r]] -= 1
                l += 1
            else:
                r += 1
                if r < len(s):
                    if s[s[r]] == t[s[r]]:
                        s_count += 1
                    s[s[r]] += 1
        return ans