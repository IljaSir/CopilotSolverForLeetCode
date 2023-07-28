class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # build graph
        graph = {}
        for i in range(numCourses):
            graph[i] = []
        for p in prerequisites:
            graph[p[0]].append(p[1])
        #print(graph)
        
        # build indegree
        indegree = {}
        for i in range(numCourses):
            indegree[i] = 0
        for p in prerequisites:
            indegree[p[1]] += 1
        #print(indegree)
        
        # BFS
        queue = []
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        #print(queue)
        
        res = []
        while queue:
            node = queue.pop(0)
            res.append(node)
            for n in graph[node]:
                indegree[n] -= 1
                if indegree[n] == 0:
                    queue.append(n)
        #print(res)
        
        if len(res) != numCourses:
            return []
        else:
            return res