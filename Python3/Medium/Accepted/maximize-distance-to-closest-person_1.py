class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        n = len(seats)
        dist = [n] * n
        last = -n
        for i in range(n):
            if seats[i]:
                last = i
            dist[i] = i - last
        last = 2 * n
        for i in range(n-1, -1, -1):
            if seats[i]:
                last = i
            dist[i] = min(dist[i], last - i)
        return max(dist)