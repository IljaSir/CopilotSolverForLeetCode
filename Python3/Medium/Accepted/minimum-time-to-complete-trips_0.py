class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        
        def check(t):
            return sum(t // x for x in time) >= totalTrips
        l, r = 1, 10 ** 14
        while l < r:
            m = (l + r) // 2
            if check(m):
                r = m
            else:
                l = m + 1
        return l