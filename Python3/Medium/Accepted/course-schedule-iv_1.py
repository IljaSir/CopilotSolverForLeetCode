class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        
        # if not prerequisites or not queries:
        #     return [False for _ in queries]
        # graph = {}
        # for i, j in prerequisites:
        #     graph[i] = graph.get(i, []) + [j]
        # for i in range(numCourses):
        #     if i not in graph:
        #         graph[i] = []
        # def dfs(start, end):
        #     if start == end:
        #         return True
        #     if start not in graph:
        #         return False
        #     for i in graph[start]:
        #         if dfs(i, end):
        #             return True
        #     return False
        # res = []
        # for i, j in queries:
        #     res.append(dfs(i, j))
        # return res
        graph = [[0 for _ in range(numCourses)] for _ in range(numCourses)]
        for i, j in prerequisites:
            graph[i][j] = 1
        for k in range(numCourses):
            for i in range(numCourses):
                for j in range(numCourses):
                    graph[i][j] = graph[i][j] or (graph[i][k] and graph[k][j])
        res = []
        for i, j in queries:
            res.append(graph[i][j])
        return res