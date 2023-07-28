class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        
        return sum(abs(s - t) for s, t in zip(sorted(seats), sorted(students)))