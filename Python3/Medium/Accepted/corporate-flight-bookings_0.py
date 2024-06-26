class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        
        ans = [0] * n
        for i, j, k in bookings:
            ans[i-1] += k
            if j < n:
                ans[j] -= k
        for i in range(1, n):
            ans[i] += ans[i-1]
        return ans