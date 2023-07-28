class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        
        
        # construct graph
        graph = collections.defaultdict(list)
        for u, v in relations:
            graph[u].append(v)
        
        # construct in-degrees
        in_degrees = [0] * (n+1)
        for u in graph:
            for v in graph[u]:
                in_degrees[v] += 1
        
        # init queue
        q = collections.deque()
        for i in range(1, n+1):
            if in_degrees[i] == 0:
                q.append(i)
        
        # bfs
        res = 0
        while q:
            size = len(q)
            for _ in range(size):
                u = q.popleft()
                res += time[u-1]
                for v in graph[u]:
                    in_degrees[v] -= 1
                    if in_degrees[v] == 0:
                        q.append(v)
        return res