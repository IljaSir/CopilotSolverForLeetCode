class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        # 1. sort ranks in descending order
        # 2. for each rank, calculate the number of cars it can fix in 1 unit of time
        # 3. use binary search to find the minimum time
        # 4. for a given time, calculate the number of cars fixed and compare with cars
        ranks.sort(reverse=True)
        n = len(ranks)
        def fixed_cars(time):
            res = 0
            for i in range(n):
                res += (time // ranks[i]) ** 2
            return res
        left, right = 0, 2 * 10 ** 9
        while left < right:
            mid = (left + right) // 2
            if fixed_cars(mid) < cars:
                left = mid + 1
            else:
                right = mid
        return left