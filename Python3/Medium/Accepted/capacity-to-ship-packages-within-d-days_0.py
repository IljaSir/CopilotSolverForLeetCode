class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        
        def canShip(weights, days, capacity):
            d = 1
            sum = 0
            for weight in weights:
                sum += weight
                if sum > capacity:
                    sum = weight
                    d += 1
            return d <= days

        l, r = max(weights), sum(weights)
        while l < r:
            mid = l + (r - l) // 2
            if canShip(weights, days, mid):
                r = mid
            else:
                l = mid + 1
        return l