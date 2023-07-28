class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # 1. build graph
        graph = [[] for _ in range(numCourses)]
        for pre in prerequisites:
            graph[pre[1]].append(pre[0])
        
        # 2. use dfs to detect cycle
        visited = [0] * numCourses
        for i in range(numCourses):
            if not self.dfs(graph, visited, i):
                return False
        return True