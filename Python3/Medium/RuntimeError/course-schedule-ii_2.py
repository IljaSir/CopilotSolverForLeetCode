class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        graph = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            graph[a].append(b)
        visited = [0] * numCourses
        res = []
        for i in range(numCourses):
            if not self.dfs(graph, visited, res, i):
                return []
        return res