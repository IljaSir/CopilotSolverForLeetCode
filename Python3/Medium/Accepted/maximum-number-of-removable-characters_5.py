class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        
        def check(k):
            t = list(s)
            for i in range(k):
                t[removable[i]] = ''
            j = 0
            for i in range(len(t)):
                if j < len(p) and p[j] == t[i]:
                    j += 1
            return j == len(p)
        l, r = 0, len(removable)
        while l < r:
            m = (l + r + 1) // 2
            if check(m):
                l = m
            else:
                r = m - 1
        return l