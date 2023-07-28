class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        t = collections.Counter(t)
        ans = (0, float('inf'))
        l = 0
        for r, c in enumerate(s):
            if t[c] > 0:
                t[c] -= 1
                if sum(t.values()) == 0:
                    while l < r and t[s[l]] < 0:
                        t[s[l]] += 1
                        l += 1
                    if r - l < ans[1] - ans[0]:
                        ans = (l, r)
                    t[s[l]] += 1
                    l += 1
        if ans[1] > len(s):
            return ''
        else:
            return s[ans[0]:ans[1]+1]