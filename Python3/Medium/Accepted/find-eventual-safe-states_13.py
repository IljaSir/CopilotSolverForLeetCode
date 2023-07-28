class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
        from collections import deque
        n = len(graph)
        # 0: white, 1: grey, 2: black
        colors = [0] * n
        ans = []
        def dfs(i):
            if colors[i] == 1:
                return False
            if colors[i] == 2:
                return True
            colors[i] = 1
            for j in graph[i]:
                if not dfs(j):
                    return False
            colors[i] = 2
            return True
        for i in range(n):
            if dfs(i):
                ans.append(i)
        return ans