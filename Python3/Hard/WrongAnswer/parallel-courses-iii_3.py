class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        
        
        # topological sort
        # https://www.youtube.com/watch?v=ddTC4Zovtbc
        # https://www.youtube.com/watch?v=5jK1tX5XZgA
        # https://www.youtube.com/watch?v=QnC8W4I4x3o
        # https://www.youtube.com/watch?v=0rT3Tq3Kj6w
        # https://www.youtube.com/watch?v=ZQktxiqyiLA
        # https://www.youtube.com/watch?v=5jK1tX5XZgA
        # https://www.youtube.com/watch?v=5jK1tX5XZgA
        
        # build graph
        graph = {}
        for i in range(1, n+1):
            graph[i] = []
        for relation in relations:
            graph[relation[0]].append(relation[1])
        
        # build indegree
        indegree = {}
        for i in range(1, n+1):
            indegree[i] = 0
        for relation in relations:
            indegree[relation[1]] += 1
        
        # topological sort
        from collections import deque
        q = deque()
        for node in indegree:
            if indegree[node] == 0:
                q.append(node)
        
        # topological sort
        ans = 0
        while q:
            node = q.popleft()
            ans += time[node-1]
            for neighbor in graph[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)
        
        return ans