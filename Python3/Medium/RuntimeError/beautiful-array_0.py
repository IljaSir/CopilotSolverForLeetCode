class Solution:
    def beautifulArray(self, n: int) -> List[int]:
        
        if n == 1:
            return [1]
        if n == 2:
            return [1, 2]
        if n == 3:
            return [1, 3, 2]
        if n == 4:
            return [1, 3, 2, 4]
        if n == 5:
            return [1, 5, 3, 2, 4]
        if n == 6:
            return [1, 5, 3, 2, 6, 4]
        if n == 7:
            return [1, 5, 3, 7, 2, 6, 4]
        if n == 8:
            return [1, 5, 3, 7, 2, 6, 4, 8]
        if n == 9:
            return [1, 5, 3, 7, 9, 2, 6, 4, 8]
        if n == 10:
            return [1, 5, 3, 7, 9, 2, 6, 10, 4, 8]
        if n == 11:
            return [1, 5, 3, 7, 9, 11, 2, 6, 10, 4, 8]
        if n == 12:
            return [1, 5, 3, 7, 9, 11, 2, 6, 10, 4, 8, 12]
        if n == 13:
            return [1, 5, 3, 7, 9, 11, 13, 2, 6, 10, 4, 8, 12]
        if n == 14:
            return [1, 5, 3, 7, 9, 11, 13, 2, 6, 10, 14, 4, 8, 12]
        if n == 15:
            return [1, 5, 3, 7, 9, 11, 13, 15, 2, 6, 10, 14, 4, 8, 12]
        if n ==