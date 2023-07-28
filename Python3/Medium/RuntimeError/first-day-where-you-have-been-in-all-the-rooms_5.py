class Solution:
    def firstDayBeenInAllRooms(self, nextVisit: List[int]) -> int:
        
        def dfs(i):
            if i in memo: return memo[i]
            memo[i] = (dfs(nextVisit[i]) + dfs((i + 1) % n) + 2) % mod
            return memo[i]
        n = len(nextVisit)
        mod = 10**9 + 7
        memo = {n-1: 0}
        return dfs(0)