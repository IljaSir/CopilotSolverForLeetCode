class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], time: int, change: int) -> int:
        
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        def bfs(start):
            queue = [(start, 0)]
            visited = {start}
            while queue:
                node, t = queue.pop(0)
                if node == n:
                    return t
                for nei in graph[node]:
                    if nei not in visited:
                        visited.add(nei)
                        queue.append((nei, t + time))
        ans = bfs(1)
        for i in range(1, n + 1):
            ans = min(ans, bfs(i))
        return ans