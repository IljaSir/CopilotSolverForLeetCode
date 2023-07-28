class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        graph = defaultdict(list)
        for p in prerequisites:
            graph[p[0]].append(p[1])
        visited = [0]*numCourses
        for i in range(numCourses):
            if not self.dfs(graph, visited, i):
                return False
        return True