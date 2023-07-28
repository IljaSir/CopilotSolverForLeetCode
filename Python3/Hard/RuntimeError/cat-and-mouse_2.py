class Solution:
    def catMouseGame(self, graph: List[List[int]]) -> int:
        
        def dfs(m, c, t):
            if (m, c, t) in memo: return memo[m, c, t]
            if t == 2:
                if m == 0: return 1
                if m == c: return 2
                for i in graph[m]:
                    if dfs(i, c, 3-t) == 2: return 2
                return 1
            else:
                if c == 0: return 2
                if m == c: return 1
                for i in graph[c]:
                    if i == 0: continue
                    if dfs(m, i, 3-t) == 1: return 1
                return 2
        memo = {}
        return dfs(1, 2, 1)