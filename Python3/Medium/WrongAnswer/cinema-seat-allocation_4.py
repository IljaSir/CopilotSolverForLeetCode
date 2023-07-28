class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        
        reservedSeats.sort()
        reservedSeats = [r[1] for r in reservedSeats]
        res = 0
        for i in range(0, len(reservedSeats), 2):
            if reservedSeats[i] > 2 and reservedSeats[i] < 9 and (i == len(reservedSeats) - 1 or reservedSeats[i + 1] > 6):
                res += 1
            if i < len(reservedSeats) - 1 and reservedSeats[i + 1] > 4 and reservedSeats[i + 1] < 9:
                res += 1
        return res + 2 * (n - len(reservedSeats) // 2)