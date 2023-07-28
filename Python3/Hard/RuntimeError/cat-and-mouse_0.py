class Solution:
    def catMouseGame(self, graph: List[List[int]]) -> int:
        
        N = len(graph)
        DRAW, MOUSE, CAT = 0, 1, 2
        color = collections.defaultdict(int)
        
        def dfs(i, j, t):
            if color[i, j, t]: return color[i, j, t]
            color[i, j, t] = DRAW
            if t == 2: