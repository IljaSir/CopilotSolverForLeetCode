class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        ranks.sort()
        n = len(ranks)
        lo, hi = 0, 10**11
        while lo < hi:
            mid = (lo + hi) // 2
            cnt = 0
            for i in range(n):
                cnt += (mid // (ranks[i] * (i + 1) ** 2))
                if cnt >= cars:
                    break
            if cnt >= cars:
                hi = mid
            else:
                lo = mid + 1
        return lo