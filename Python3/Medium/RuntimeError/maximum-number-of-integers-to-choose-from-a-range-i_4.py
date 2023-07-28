class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        
        banned.sort()
        def can_count(number):
            if number in banned:
                return False
            if number > maxSum:
                return False
            return True
        def count(number):
            if not can_count(number):
                return 0
            if number == 1:
                return 1
            if number == 2:
                return 2
            if number == 3:
                return 3
            if number == 4:
                return 4
            if number == 5:
                return 5
            if number == 6:
                return 6
            if number == 7:
                return 7
            if number == 8:
                return 8
            if number == 9:
                return 9
            if number == 10:
                return 10
            if number == 11:
                return 11
            if number == 12:
                return 12
            if number == 13:
                return 13
            if number == 14:
                return 14
            if number == 15:
                return 15
            if number == 16:
                return 16
            if number == 17:
                return 17
            if number == 18:
                return 18
            if number == 19:
                return 19
            if number == 20:
                return 20
            if number == 21:
                return 21
            if number == 22:
                return 22
            if number == 23:
                return 23
            if number == 24:
                return 24
            if number == 25:
                return 25
            if number == 26:
                return 26
            if number == 27:
                return 27
            if number == 28:
                return 28
            if number == 29:
                return 29
            if number == 30:
                return 30
            if number == 31:
                return 31
            if number == 32:
                return 32
            if number == 33:
                return 33
            if number == 34:
                return 34
            if number == 35:
                return 35
            if number == 36:
                return 36
            if number == 37:
                return 37
            if number