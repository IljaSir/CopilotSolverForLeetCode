class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        ranks.sort()
        def check(time):
            cnt = 0
            for r in ranks:
                cnt += time // (r * r)
                if cnt >= cars:
                    return True
            return False
        l, r = 0, 10**12
        while l < r:
            m = (l + r) // 2
            if check(m):
                r = m
            else:
                l = m + 1
        return l