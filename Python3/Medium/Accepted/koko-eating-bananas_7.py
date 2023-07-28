class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        def canFinish(piles, h, k):
            hours = 0
            for p in piles:
                hours += (p-1) // k + 1
            return hours <= h
        
        lo, hi = 1, max(piles)
        while lo < hi:
            mid = (lo + hi) // 2
            if canFinish(piles, h, mid):
                hi = mid
            else:
                lo = mid + 1
        return lo