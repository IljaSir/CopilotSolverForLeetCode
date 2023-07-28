class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        def possible(k):
            return sum((p-1)//k + 1 for p in piles) <= h
        lo, hi = 1, max(piles)
        while lo < hi:
            mi = (lo + hi) // 2
            if not possible(mi):
                lo = mi + 1
            else:
                hi = mi
        return lo