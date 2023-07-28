class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # 1. Create a graph with adjacency list
        graph = {i: [] for i in range(numCourses)}
        for edge in prerequisites:
            graph[edge[1]].append(edge[0])
        # 2. Create a visited dictionary
        visited = {i: 0 for i in range(numCourses)}
        # 3. Create a stack to store topological sort
        stack = []
        # 4. Create a function to check for cycle
        def dfs(i):
            if visited[i] == 1:
                return True
            if visited[i] == 2:
                return False
            visited[i] = 1
            for course in graph[i]:
                if dfs(course):
                    return True
            visited[i] = 2
            stack.append(i)
            return False
        # 5. Check for cycle
        for i in range(numCourses):
            if dfs(i):
                return []
        # 6. Return stack
        return stack