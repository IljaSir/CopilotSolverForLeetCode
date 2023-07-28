class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        i = 0
        while i < len(seats) and seats[i] == 0:
            i += 1
        max_dist = i
        prev = i
        while i < len(seats):
            while i < len(seats) and seats[i] == 1:
                i += 1
            if i == len(seats):
                max_dist = max(max_dist, i - prev - 1)
                break
            start = i
            while i < len(seats) and seats[i] == 0:
                i += 1
            max_dist = max(max_dist, (i - prev) // 2)
            prev = start
        return max_dist