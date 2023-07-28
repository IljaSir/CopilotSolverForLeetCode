class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        
        seats = {}
        for i in range(1, 11):
            seats[i] = 0
        for i in range(len(reservedSeats)):
            seats[reservedSeats[i][1]] += 1
        count = 0
        for i in range(1, 11):
            if seats[i] == 0:
                count += 1
        return count