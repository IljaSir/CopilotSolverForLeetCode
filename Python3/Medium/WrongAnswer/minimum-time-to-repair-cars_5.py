class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        ranks.sort()
        l = len(ranks)
        def get_time(ranks, cars):
            t = 0
            for i in range(l):
                t += ranks[i] * (cars - i)
            return t
        lo, hi = 0, cars
        while lo < hi:
            mid = (lo + hi) // 2
            if get_time(ranks, mid) < get_time(ranks, mid + 1):
                hi = mid
            else:
                lo = mid + 1
        return get_time(ranks, lo)