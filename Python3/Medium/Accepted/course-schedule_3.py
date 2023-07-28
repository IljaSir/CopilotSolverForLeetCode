class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        graph = {i: [] for i in range(numCourses)}
        for i, j in prerequisites:
            graph[j].append(i)
        visited = [0] * numCourses
        def dfs(node):
            if visited[node] == 1:
                return True
            if visited[node] == -1:
                return False
            visited[node] = -1
            for i in graph[node]:
                if not dfs(i):
                    return False
            visited[node] = 1
            return True
        for i in range(numCourses):
            if not dfs(i):
                return False
        return True