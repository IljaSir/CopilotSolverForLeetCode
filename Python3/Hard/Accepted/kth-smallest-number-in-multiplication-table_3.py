class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        
        def enough(x):
            cnt = 0
            for i in range(1, m+1):
                cnt += min(x//i, n)
            return cnt >= k
        lo, hi = 1, m*n
        while lo < hi:
            mi = (lo + hi) // 2
            if enough(mi):
                hi = mi
            else:
                lo = mi + 1
        return lo