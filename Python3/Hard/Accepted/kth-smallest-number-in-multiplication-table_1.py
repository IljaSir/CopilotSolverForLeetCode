class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        
        def enough(x):
            return sum(min(x // i, n) for i in range(1, m + 1)) >= k
        lo, hi = 1, m * n
        while lo < hi:
            mi = (lo + hi) // 2
            if enough(mi):
                hi = mi
            else:
                lo = mi + 1
        return lo