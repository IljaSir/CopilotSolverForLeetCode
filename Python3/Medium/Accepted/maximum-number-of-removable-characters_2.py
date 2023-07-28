class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        
        def isSubsequence(s, p):
            i = 0
            for c in s:
                if i < len(p) and c == p[i]:
                    i += 1
            return i == len(p)
        l, r = 0, len(removable)
        while l < r:
            m = (l + r + 1) // 2
            s2 = list(s)
            for i in removable[:m]:
                s2[i] = ''
            if isSubsequence(''.join(s2), p):
                l = m
            else:
                r = m - 1
        return l