class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        def canFinish(piles, speed, h):
            time = 0
            for pile in piles:
                time += pile // speed
                if pile % speed != 0:
                    time += 1
            return time <= h
        
        l, r = 1, max(piles)
        while l < r:
            mid = l + (r - l) // 2
            if canFinish(piles, mid, h):
                r = mid
            else:
                l = mid + 1
        return l