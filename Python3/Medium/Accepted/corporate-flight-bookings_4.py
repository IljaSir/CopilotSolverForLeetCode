class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        
        delta = [0] * n
        for i, j, k in bookings:
            delta[i-1] += k
            if j < n:
                delta[j] -= k
        for i in range(1, n):
            delta[i] += delta[i-1]
        return delta