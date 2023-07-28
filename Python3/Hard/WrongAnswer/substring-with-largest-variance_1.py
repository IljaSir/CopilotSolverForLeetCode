class Solution:
    def largestVariance(self, s: str) -> int:
        
        n = len(s)
        d = {}
        for i in range(n):
            c = s[i]
            if c not in d:
                d[c] = []
            d[c].append(i)
        ans = 0
        for c in d:
            l = d[c]
            for i in range(len(l)):
                for j in range(i+1, len(l)):
                    ans = max(ans, l[j]-l[i])
        return ans