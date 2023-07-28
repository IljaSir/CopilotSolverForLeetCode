class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        max_dist = 0
        for i in range(len(seats)):
            if seats[i] == 0:
                dist = 0
                j = i
                while j>=0 and seats[j] == 0:
                    dist += 1
                    j -= 1
                if j < 0:
                    dist -= 1
                else:
                    dist -= 0.5
                j = i
                while j<len(seats) and seats[j] == 0:
                    dist += 1
                    j += 1
                if j >= len(seats):
                    dist -= 1
                else:
                    dist -= 0.5
                max_dist = max(max_dist, int(dist))
        return max_dist