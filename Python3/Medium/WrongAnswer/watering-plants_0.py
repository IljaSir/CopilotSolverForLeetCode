class Solution:
    def wateringPlants(self, plants: List[int], capacity: int) -> int:
        
        steps = 0
        water = 0
        for plant in plants:
            if plant > water:
                steps += (plant - water)
                water = capacity
            water -= plant
            steps += 1
        return steps - 1