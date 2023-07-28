class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        
        n = len(quiet)
        graph = [[] for _ in range(n)]
        for x, y in richer:
            graph[y].append(x)
        ans = [None] * n
        def dfs(x):
            if ans[x] is None:
                ans[x] = x
                for y in graph[x]:
                    if quiet[ans[x]] > quiet[dfs(y)]:
                        ans[x] = ans[y]
            return ans[x]
        for i in range(n):
            dfs(i)
        return ans