class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        def can_repair(cars, ranks, time):
            repair = 0
            for rank in ranks:
                repair += (time // (rank * rank))
            return repair >= cars
        ranks = sorted(ranks)
        left, right = 0, ranks[-1] * ranks[-1] * cars
        while left < right:
            mid = (left + right) // 2
            if can_repair(cars, ranks, mid):
                right = mid
            else:
                left = mid + 1
        return left