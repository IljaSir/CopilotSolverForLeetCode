class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        def canFinish(piles, h, k):
            return sum((pile-1)//k+1 for pile in piles) <= h
        l, r = 1, max(piles)
        while l < r:
            m = (l+r)//2
            if canFinish(piles, h, m):
                r = m
            else:
                l = m+1
        return l