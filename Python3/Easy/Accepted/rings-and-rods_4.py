class Solution:
    def countPoints(self, rings: str) -> int:
        
        n = len(rings) // 2
        count = 0
        for i in range(10):
            if rings.count('R' + str(i)) > 0 and rings.count('G' + str(i)) > 0 and rings.count('B' + str(i)) > 0:
                count += 1
        return count