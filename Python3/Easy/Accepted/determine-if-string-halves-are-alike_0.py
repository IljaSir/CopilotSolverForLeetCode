class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        
        n = len(s)
        a = s[:n//2]
        b = s[n//2:]
        a_cnt = 0
        b_cnt = 0
        for c in a:
            if c in 'aeiouAEIOU':
                a_cnt += 1
        for c in b:
            if c in 'aeiouAEIOU':
                b_cnt += 1
        return a_cnt == b_cnt