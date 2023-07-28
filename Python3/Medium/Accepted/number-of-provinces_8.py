class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        def dfs(i, n, visited):
            for j in range(n):
                if isConnected[i][j] and j not in visited:
                    visited.add(j)
                    dfs(j, n, visited)
        n = len(isConnected)
        visited = set()
        provinces = 0
        for i in range(n):
            if i not in visited:
                provinces += 1
                dfs(i, n, visited)
        return provinces