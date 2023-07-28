class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        self.n = len(isConnected)
        self.visited = [False] * self.n
        self.isConn = isConnected
        self.cnt = 0
        for i in range(self.n):
            if not self.visited[i]:
                self.dfs(i)
                self.cnt += 1
        return self.cnt