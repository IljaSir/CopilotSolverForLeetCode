class Solution:
    def balancedString(self, s: str) -> int:
        
        n = len(s)
        if n % 4 != 0:
            return 0
        n = n // 4
        d = {}
        for c in s:
            if c not in d:
                d[c] = 0
            d[c] += 1
        ans = 0
        for c, v in d.items():
            if v > n:
                ans += v - n
        return ans