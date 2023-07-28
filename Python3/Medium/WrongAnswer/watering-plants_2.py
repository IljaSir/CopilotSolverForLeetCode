class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        
        if len(plants) == 1:
            return plants[0]
        steps = 0
        for i in range(1, len(plants)):
            steps += abs(plants[i] - plants[i-1]) + 1
            if plants[i] > capacity:
                steps += plants[i] - capacity
        return steps