class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        
        def dfs(graph, start, end, visited):
            if start == end:
                return True
            for node in graph[start]:
                if node not in visited:
                    visited.add(node)
                    if dfs(graph, node, end, visited):
                        return True
            return False
        graph = {i:[] for i in range(numCourses)}
        for pair in prerequisites:
            graph[pair[0]].append(pair[1])
        res = []
        for query in queries:
            res.append(dfs(graph, query[0], query[1], set()))
        return res