class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        graph = [[] for _ in range(numCourses)]
        indegree = [0 for _ in range(numCourses)]
        for u, v in prerequisites:
            graph[v].append(u)
            indegree[u] += 1
        queue = collections.deque([u for u in range(numCourses) if indegree[u] == 0])
        order = []
        while queue:
            u = queue.popleft()
            order.append(u)
            for v in graph[u]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    queue.append(v)
        if len(order) == numCourses:
            return order
        return []