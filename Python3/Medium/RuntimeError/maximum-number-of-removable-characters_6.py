class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        
        def isSubsequence(s, p):
            s, p = iter(s), iter(p)
            return all(c in s for c in p)
        l, r = 0, len(removable)
        while l < r:
            m = (l + r + 1) // 2
            if isSubsequence(s, p, removable[:m]):
                l = m
            else:
                r = m - 1
        return l