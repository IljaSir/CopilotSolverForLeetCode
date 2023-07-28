class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        
        seats = [i for i, x in enumerate(seats) if x == 1]
        print(seats)
        return max(seats[0], len(seats) - seats[-1] - 1, *[b - a >> 1 for a, b in zip(seats, seats[1:])])