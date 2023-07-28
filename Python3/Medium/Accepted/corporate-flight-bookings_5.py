class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        
        counts = [0] * (n + 1)
        for i, j, k in bookings:
            counts[i - 1] += k
            counts[j] -= k
        for i in range(1, n):
            counts[i] += counts[i - 1]
        return counts[:-1]