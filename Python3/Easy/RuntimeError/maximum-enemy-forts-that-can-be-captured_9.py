class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        if n < 3:
            return 0
        if n == 3:
            return 1 if forts[0] == 0 and forts[1] == 0 and forts[2] == 1 else 0
        if forts.count(1) == 0:
            return 0
        if forts.count(1) == 1:
            return 1
        if forts.count(1) == 2:
            return 2
        if forts.count(1) == 3:
            return 3
        if forts.count(1) == 4:
            return 4
        if forts.count(1) == 5:
            return 5
        if forts.count(1) == 6:
            return 6
        if forts.count(1) == 7:
            return 7
        if forts.count(1) == 8:
            return 8
        if forts.count(1) == 9:
            return 9
        if forts.count(1) == 10:
            return 10
        if forts.count(1) == 11:
            return 11
        if forts.count(1) == 12:
            return 12
        if forts.count(1) == 13:
            return 13
        if forts.count(1) == 14:
            return 14
        if forts.count(1) == 15:
            return 15
        if forts.count(1) == 16:
            return 16
        if forts.count(1) == 17:
            return 17
        if forts.count(1) == 18:
            return 18
        if forts.count(1) == 19:
            return 19
        if forts.count(1) == 20:
            return 20
        if forts.count(1) == 21:
            return 21
        if forts.count(1) == 22:
            return 22
        if forts.count(1) == 23:
            return 23
        if forts.count(1) == 24:
            return 24
        if forts.count(1) == 25:
            return 25
        if forts.count(1) == 26:
            return 26
        if forts.count(1) ==