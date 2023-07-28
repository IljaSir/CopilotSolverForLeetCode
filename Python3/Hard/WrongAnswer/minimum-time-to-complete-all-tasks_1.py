class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        
        tasks.sort(key=lambda x: x[0])
        t = 0
        for start, end, duration in tasks:
            if t < start:
                t = start + duration
            else:
                t += duration
        return t