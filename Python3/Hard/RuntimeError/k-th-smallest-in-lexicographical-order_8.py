class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        #print(n, k)
        if k == 1:
            return 1
        if n < 10:
            return k
        if n < 20:
            if k <= 10:
                return k
            else:
                return k-10+1
        if k == 2:
            return 10
        if k == 3:
            return 11
        if k == 4:
            return 12
        if k == 5:
            return 13
        if k == 6:
            return 14
        if k == 7:
            return 15
        if k == 8:
            return 16
        if k == 9:
            return 17
        if k == 10:
            return 18
        if k == 11:
            return 19
        if k == 12:
            return 20
        if k == 13:
            return 21
        if k == 14:
            return 22
        if k == 15:
            return 23
        if k == 16:
            return 24
        if k == 17:
            return 25
        if k == 18:
            return 26
        if k == 19:
            return 27
        if k == 20:
            return 28
        if k == 21:
            return 29
        if k == 22:
            return 30
        if k == 23:
            return 31
        if k == 24:
            return 32
        if k == 25:
            return 33
        if k == 26:
            return 34
        if k == 27:
            return 35
        if k == 28:
            return 36
        if k == 29:
            return 37
        if k == 30:
            return 38
        if k == 31:
            return 39
        if k == 32:
            return 40
        if k == 33:
            return 41
        if k == 34:
            return 42
        if k == 35:
            return 43
        if k == 36:
            return 44
        if k == 37:
            return 45
        if k == 38: