class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        
        if not matchsticks: return False
        n = len(matchsticks)
        if n < 4: return False
        total = sum(matchsticks)
        if total % 4 != 0: return False
        target = total // 4
        matchsticks.sort(reverse=True)
        if matchsticks[0] > target: return False
        used = [False] * n
        def dfs(i, k, cur):
            if k == 0: return True
            if cur == target:
                return dfs(0, k-1, 0)
            for j in range(i, n):
                if not used[j] and cur + matchsticks[j] <= target:
                    used[j] = True
                    if dfs(j+1, k, cur+matchsticks[j]):
                        return True
                    used[j] = False
            return False
        return dfs(0, 4, 0)