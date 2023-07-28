class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        ranks.sort(reverse=True)
        n = len(ranks)
        def f(x):
            return sum(x // (ranks[i] * (i + 1) ** 2) for i in range(n))
        l, r = 0, 10 ** 18
        while l < r:
            mid = (l + r) // 2
            if f(mid) >= cars:
                r = mid
            else:
                l = mid + 1
        return l