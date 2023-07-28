class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        times = [int(t[:2])*60+int(t[3:]) for t in timePoints]
        times.sort()
        times.append(times[0]+24*60)
        return min(times[i+1]-times[i] for i in range(len(times)-1))