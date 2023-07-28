class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        
        return sum(abs(b-a) for a,b in zip(sorted(seats), sorted(students)))