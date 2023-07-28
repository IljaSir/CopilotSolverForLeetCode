class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # build graph
        graph = [[] for _ in range(numCourses)]
        for pair in prerequisites:
            graph[pair[1]].append(pair[0])
        # build in-degree
        in_degree = [0 for _ in range(numCourses)]
        for pair in prerequisites:
            in_degree[pair[0]] += 1
        # bfs
        queue = []
        for i in range(numCourses):
            if in_degree[i] == 0:
                queue.append(i)
        res = []
        while queue:
            node = queue.pop(0)
            res.append(node)
            for neighbor in graph[node]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    queue.append(neighbor)
        if len(res) == numCourses:
            return res
        else:
            return []