class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        
        # 1. Build graph
        graph = [[] for _ in range(numCourses)]
        for u, v in prerequisites:
            graph[u].append(v)
        
        # 2. Check for cycle
        visited = [False] * numCourses
        for u in range(numCourses):
            if not visited[u]:
                if self.hasCycle(graph, visited, u):
                    return False
        return True