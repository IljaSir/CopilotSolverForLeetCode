class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        
        def is_ok(t):
            trips = 0
            for x in time:
                trips += t // x
            return trips >= totalTrips
        lo, hi = 0, 10**14
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if is_ok(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo