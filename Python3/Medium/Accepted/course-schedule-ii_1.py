class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        for u, v in prerequisites:
            graph[v].append(u)
            indegree[u] += 1
        stack = [i for i in range(numCourses) if indegree[i] == 0]
        res = []
        while stack:
            node = stack.pop()
            res.append(node)
            for v in graph[node]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    stack.append(v)
        if len(res) != numCourses:
            return []
        return res