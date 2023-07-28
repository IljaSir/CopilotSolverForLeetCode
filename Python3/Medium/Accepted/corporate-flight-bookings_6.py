class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        
        l = [0] * (n+1)
        for b in bookings:
            l[b[0]-1] += b[2]
            if b[1] < n:
                l[b[1]] -= b[2]
        for i in range(1, n):
            l[i] += l[i-1]
        return l[:-1]