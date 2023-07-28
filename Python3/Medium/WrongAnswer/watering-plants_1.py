class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        
        ans = 0
        cur = 0
        for i in range(len(plants)):
            if cur < plants[i]:
                ans += 2 * (i - 1) + 2
                cur = capacity - plants[i]
            else:
                cur -= plants[i]
        return ans