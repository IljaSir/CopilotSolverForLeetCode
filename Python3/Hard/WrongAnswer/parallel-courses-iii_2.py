class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        
        
        # 1. Build the graph
        graph = collections.defaultdict(set)
        for prev, next in relations:
            graph[prev].add(next)
        
        # 2. Topological sort
        indegree = [0 for _ in range(n+1)]
        for prev, next in relations:
            indegree[next] += 1
        
        queue = collections.deque()
        for i in range(1, n+1):
            if indegree[i] == 0:
                queue.append(i)
        
        res = 0
        while queue:
            size = len(queue)
            res += 1
            for _ in range(size):
                cur = queue.popleft()
                for next in graph[cur]:
                    indegree[next] -= 1
                    if indegree[next] == 0:
                        queue.append(next)
        
        return res