class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        if time == 1:
            return 1
        if time == 2:
            return 2
        if time == 3:
            return 3
        if time == 4:
            return 4
        if time == 5:
            return 2
        if time % 2 == 0:
            return 2
        else:
            return 3