class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        
        def check(x):
            count = 0
            for t in time:
                count += x//t
            return count >= totalTrips
        left, right = 0, max(time)*totalTrips
        while left < right:
            mid = (left + right)//2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left