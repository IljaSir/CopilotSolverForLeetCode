class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        graph = [[] for _ in range(numCourses)]
        for i, j in prerequisites:
            graph[i].append(j)
        visited = [False] * numCourses
        res = []
        def dfs(i):
            nonlocal visited
            if visited[i] == -1:
                return False
            if visited[i]:
                return True
            visited[i] = -1
            for j in graph[i]:
                if not dfs(j):
                    return False
            visited[i] = True
            res.append(i)
            return True
        for i in range(numCourses):
            if not dfs(i):
                return []
        return res