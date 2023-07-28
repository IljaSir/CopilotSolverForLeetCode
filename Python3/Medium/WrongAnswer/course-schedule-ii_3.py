class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        adj = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            adj[b].append(a)
        visited = [0] * numCourses
        res = []
        def dfs(i):
            if visited[i] == 1:
                return True
            if visited[i] == 2:
                return False
            visited[i] = 1
            for j in adj[i]:
                if dfs(j):
                    return True
            visited[i] = 2
            res.append(i)
            return False
        for i in range(numCourses):
            if dfs(i):
                return []
        return res