class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        max_dist = 0
        last_seat = -1
        for i in range(len(seats)):
            if seats[i] == 1:
                if last_seat == -1:
                    max_dist = max(max_dist, i)
                else:
                    max_dist = max(max_dist, (i - last_seat) // 2)
                last_seat = i
        max_dist = max(max_dist, len(seats) - last_seat - 1)
        return max_dist