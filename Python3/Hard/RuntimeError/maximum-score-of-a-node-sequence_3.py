class Solution:
    def maximumScore(self, scores: List[int], edges: List[List[int]]) -> int:
        
        n = len(scores)
        g = [[] for _ in range(n)]
        for a, b in edges:
            g[a].append(b)
            g[b].append(a)
        dp = {}
        def dfs(p, u):
            if (p, u) in dp: return dp[(p, u)]
            ans = scores[u]
            for v in g[u]:
                if v == p: continue
                ans += max(0, dfs(u, v))
            dp[(p, u)] = ans
            return ans
        ans = -1
        for p, u in edges:
            ans = max(ans, dfs(p, u) + dfs(u, p))
        return ans