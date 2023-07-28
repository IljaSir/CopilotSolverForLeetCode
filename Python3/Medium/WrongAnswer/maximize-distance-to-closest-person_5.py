class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        dist = 0
        i = 0
        while i < len(seats):
            if seats[i] == 1:
                j = i + 1
                while j < len(seats) and seats[j] == 0:
                    j += 1
                if i == 0:
                    dist = max(dist, j - i)
                elif j == len(seats):
                    dist = max(dist, j - i)
                else:
                    dist = max(dist, (j - i + 1) // 2)
                i = j - 1
            i += 1
        return dist