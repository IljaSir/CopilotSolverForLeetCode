class Solution:
    def countArrangement(self, n: int) -> int:
        
        def dfs(cur, used):
            if cur > n:
                return 1
            ans = 0
            for i in range(1, n + 1):
                if not used[i] and (i % cur == 0 or cur % i == 0):
                    used[i] = True
                    ans += dfs(cur + 1, used)
                    used[i] = False
            return ans
        used = [False] * (n + 1)
        return dfs(1, used)