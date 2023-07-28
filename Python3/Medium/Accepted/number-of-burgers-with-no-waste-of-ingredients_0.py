class Solution:
    def numOfBurgers(self, tomatoSlices: int, cheeseSlices: int) -> List[int]:
        
        if tomatoSlices % 2 != 0:
            return []
        if tomatoSlices == 0 and cheeseSlices == 0:
            return [0, 0]
        if tomatoSlices == 0 or cheeseSlices == 0:
            return []
        if tomatoSlices < 2 * cheeseSlices:
            return []
        if 4 * cheeseSlices < tomatoSlices:
            return []
        return [(tomatoSlices - 2 * cheeseSlices) // 2, cheeseSlices - (tomatoSlices - 2 * cheeseSlices) // 2]