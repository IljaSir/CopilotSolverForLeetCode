class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        
        n = len(stations)
        if k >= n:
            return 1
        def possible(p):
            cnt = 0
            for i in range(n-1):
                cnt += (stations[i+1] - stations[i] - 1) // (2*r + 1)
            return cnt <= k
        l, r = 1, 10**5
        while l < r:
            mid = (l + r + 1) // 2
            if possible(mid):
                l = mid
            else:
                r = mid - 1
        return l