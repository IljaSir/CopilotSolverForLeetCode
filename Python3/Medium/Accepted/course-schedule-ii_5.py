class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        adjList = [[] for _ in range(numCourses)]
        for pair in prerequisites:
            adjList[pair[0]].append(pair[1])
        
        visited = [0] * numCourses
        stack = []
        def dfs(node):
            if visited[node] == -1:
                return False
            if visited[node] == 1:
                return True
            visited[node] = -1
            for n in adjList[node]:
                if not dfs(n):
                    return False
            visited[node] = 1
            stack.append(node)
            return True
        
        for node in range(numCourses):
            if not dfs(node):
                return []
        return stack