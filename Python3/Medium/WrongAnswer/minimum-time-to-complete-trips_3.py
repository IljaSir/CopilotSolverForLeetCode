class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        
        def check(t):
            return sum(t//t_i for t_i in time) >= totalTrips
        left, right = 1, 10**7
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left