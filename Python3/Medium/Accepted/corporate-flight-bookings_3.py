class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        
        d = [0] * (n + 1)
        for i, j, k in bookings:
            d[i - 1] += k
            d[j] -= k
        for i in range(1, n):
            d[i] += d[i - 1]
        return d[:-1]