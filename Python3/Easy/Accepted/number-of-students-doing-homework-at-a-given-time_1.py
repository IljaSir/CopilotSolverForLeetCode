class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        
        
        return sum([1 if startTime[i] <= queryTime <= endTime[i] else 0 for i in range(len(startTime))])