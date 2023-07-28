class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        n = len(isConnected)
        visited = [False for _ in range(n)]
        ans = 0
        for i in range(n):
            if not visited[i]:
                ans += 1
                self.dfs(i, isConnected, visited)
        return ans