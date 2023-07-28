class Solution:
    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        
        
        start = max(arriveAlice, arriveBob)
        end = min(leaveAlice, leaveBob)
        
        if start > end:
            return 0
        
        start = int(start.split('-')[1])
        end = int(end.split('-')[1])
        
        return end - start + 1