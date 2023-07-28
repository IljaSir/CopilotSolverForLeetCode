class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        
        def is_subsequence(s, p):
            i = 0
            for c in s:
                if i < len(p) and c == p[i]:
                    i += 1
            return i == len(p)
        lo, hi = 0, len(removable)
        while lo < hi:
            mid = (lo + hi + 1) // 2
            s = list(s)
            for i in removable[:mid]:
                s[i] = ''
            if is_subsequence(''.join(s), p):
                lo = mid
            else:
                hi = mid - 1
        return lo