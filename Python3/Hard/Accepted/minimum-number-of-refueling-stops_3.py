class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        
        stations.append([target, 0])
        n = len(stations)
        dp = [startFuel] + [0] * n
        for i in range(n):
            for t in range(i, -1, -1):
                if dp[t] >= stations[i][0]:
                    dp[t+1] = max(dp[t+1], dp[t] + stations[i][1])
        for i, d in enumerate(dp):
            if d >= target: return i
        return -1