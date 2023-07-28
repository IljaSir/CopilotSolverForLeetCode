class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        graph = {}
        for i in range(numCourses):
            graph[i] = []
        for i, j in prerequisites:
            graph[i].append(j)
        visited = [False] * numCourses
        stack = []
        def dfs(i):
            if visited[i]:
                return False
            visited[i] = True
            for j in graph[i]:
                if not dfs(j):
                    return False
            visited[i] = False
            stack.append(i)
            return True
        for i in range(numCourses):
            if not dfs(i):
                return []
        return stack