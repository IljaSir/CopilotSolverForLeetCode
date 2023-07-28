class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        n = len(isConnected)
        visited = [False]*n
        def dfs(i):
            for j in range(n):
                if isConnected[i][j] and not visited[j]:
                    visited[j] = True
                    dfs(j)
        ans = 0
        for i in range(n):
            if not visited[i]:
                ans += 1
                dfs(i)
        return ans