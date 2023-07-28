class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        N = len(seats)
        dist = [N] * N
        last = -N
        for i in range(N):
            if seats[i] == 1:
                last = i
            dist[i] = min(dist[i], i - last)
        last = 2 * N
        for i in range(N - 1, -1, -1):
            if seats[i] == 1:
                last = i
            dist[i] = min(dist[i], last - i)
        return max(dist)