class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        
        n = len(stations)
        dp = [startFuel] + [0] * n
        for i, (s, f) in enumerate(stations):
            for t in range(i, -1, -1):
                if dp[t] >= s:
                    dp[t + 1] = max(dp[t + 1], dp[t] + f)
        for i, d in enumerate(dp):
            if d >= target:
                return i
        return -1