class Solution:
    def countArrangement(self, n: int) -> int:
        
        def dfs(pos, used):
            if pos == n + 1:
                return 1
            ans = 0
            for i in range(1, n + 1):
                if not used[i] and (pos % i == 0 or i % pos == 0):
                    used[i] = True
                    ans += dfs(pos + 1, used)
                    used[i] = False
            return ans
        used = [False] * (n + 1)
        return dfs(1, used)