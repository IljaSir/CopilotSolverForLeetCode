class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        n = len(words)
        dp = [[0]*n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                for k in range(min(len(words[i]), len(words[j])), -1, -1):
                    if words[i][-k:] == words[j][:k]:
                        dp[i][j] = k
                        break
        @lru_cache(None)
        def dfs(mask, last):
            if mask == (1 << n) - 1:
                return ""
            ans = ""
            for i in range(n):
                if not (mask & (1 << i)):
                    tmp = words[i][dp[last][i]:] + dfs(mask | (1 << i), i)
                    if not ans or len(tmp) < len(ans):
                        ans = tmp
            return ans
        return dfs(0, n)