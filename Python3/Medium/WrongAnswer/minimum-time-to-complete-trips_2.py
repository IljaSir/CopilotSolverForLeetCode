class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        
        def check(t):
            return sum(t // t_i for t_i in time) >= totalTrips
        l, r = 1, 10**7
        while l < r:
            m = (l + r) // 2
            if check(m):
                r = m
            else:
                l = m + 1
        return l