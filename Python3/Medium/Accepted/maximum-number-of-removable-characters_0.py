class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        
        def is_subsequence(s, p):
            i, j = 0, 0
            while i < len(s) and j < len(p):
                if s[i] == p[j]:
                    j += 1
                i += 1
            return j == len(p)
        l, r = 0, len(removable)
        while l < r:
            m = (l + r + 1) // 2
            s2 = list(s)
            for i in removable[:m]:
                s2[i] = ""
            if is_subsequence(s2, p):
                l = m
            else:
                r = m - 1
        return l