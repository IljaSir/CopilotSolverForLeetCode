class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        
        ranks.sort()
        res = 0
        while cars > 0:
            for i in range(len(ranks)):
                if cars > 0:
                    res += ranks[i]
                    cars -= 1
        return res