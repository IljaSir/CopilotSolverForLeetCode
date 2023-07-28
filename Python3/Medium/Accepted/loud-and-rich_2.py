class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        
        n = len(quiet)
        g = [[] for _ in range(n)]
        for x, y in richer:
            g[y].append(x)
        ans = [None] * n
        def dfs(i):
            if ans[i] is not None:
                return ans[i]
            ans[i] = i
            for j in g[i]:
                if quiet[ans[i]] > quiet[dfs(j)]:
                    ans[i] = ans[j]
            return ans[i]
        for i in range(n):
            dfs(i)
        return ans