class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        def getMinute(time):
            h, m = time.split(":")
            return int(h) * 60 + int(m)
        minutes = [getMinute(x) for x in timePoints]
        minutes.sort()
        minutes.append(minutes[0] + 24 * 60)
        return min(y - x for x, y in zip(minutes, minutes[1:]))