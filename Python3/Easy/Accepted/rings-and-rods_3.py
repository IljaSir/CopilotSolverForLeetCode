class Solution:
    def countPoints(self, rings: str) -> int:
        
        counter = 0
        for i in range(0, 10):
            if 'R' + str(i) in rings and 'G' + str(i) in rings and 'B' + str(i) in rings:
                counter += 1
        return counter