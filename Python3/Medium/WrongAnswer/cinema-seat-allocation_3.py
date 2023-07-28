class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        
        reservedSeats.sort()
        ans = n * 2
        for k, g in itertools.groupby(reservedSeats, key=lambda x: x[0]):
            seats = set()
            for i, j in g:
                seats.add(j)
            if 2 in seats or 3 in seats or 4 in seats or 5 in seats:
                ans -= 1
            if 6 in seats or 7 in seats or 8 in seats or 9 in seats:
                ans -= 1
            if 2 not in seats and 3 not in seats and 4 not in seats and 5 not in seats and 6 not in seats and 7 not in seats and 8 not in seats and 9 not in seats:
                ans -= 1
        return ans