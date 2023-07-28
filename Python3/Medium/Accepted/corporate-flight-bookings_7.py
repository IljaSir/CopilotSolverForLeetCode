class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        
        # create a list of zeros
        answer = [0] * n
        # loop through the bookings
        for booking in bookings:
            # add seats to the first and last index
            answer[booking[0] - 1] += booking[2]
            if booking[1] < n:
                answer[booking[1]] -= booking[2]
        # loop through the answer list
        for i in range(1, n):
            # add the previous value to the current value
            answer[i] += answer[i - 1]
        # return the answer
        return answer