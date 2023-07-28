class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        def dfs(i):
            for j in range(n):
                if isConnected[i][j] and j not in seen:
                    seen.add(j)
                    dfs(j)
        n = len(isConnected)
        seen = set()
        res = 0
        for i in range(n):
            if i not in seen:
                dfs(i)
                res += 1
        return res