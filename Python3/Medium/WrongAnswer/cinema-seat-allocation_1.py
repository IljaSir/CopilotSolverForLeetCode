class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        
        reservedSeats.sort()
        # print(reservedSeats)
        res = 0
        i = 0
        while i < len(reservedSeats):
            j = i
            while j < len(reservedSeats) and reservedSeats[j][0] == reservedSeats[i][0]:
                j += 1
            # print(i, j)
            if j - i >= 2:
                res += (j - i - 1) // 2
            # print(res)
            if reservedSeats[i][1] <= 4:
                res += 1
                i = j
                continue
            if reservedSeats[i][1] >= 7:
                res += 1
                i = j
                continue
            if j - i >= 4:
                res += 1
                i = j
                continue
            i = j
        res += (n - len(reservedSeats) // 2) * 2
        return res