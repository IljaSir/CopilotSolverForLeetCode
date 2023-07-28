class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        
        def is_subsequence(s, p):
            i = 0
            for c in s:
                if i < len(p) and c == p[i]:
                    i += 1
            return i == len(p)
        l, r = 0, len(removable)
        while l < r:
            m = (l + r + 1) // 2
            s1 = list(s)
            for i in removable[:m]:
                s1[i] = ''
            if is_subsequence(''.join(s1), p):
                l = m
            else:
                r = m - 1
        return l