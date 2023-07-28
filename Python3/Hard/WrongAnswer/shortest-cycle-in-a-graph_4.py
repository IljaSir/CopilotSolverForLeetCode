class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        min_cycle = float('inf')
        for u in range(n):
            queue = [(u, -1, 0)]
            visited = set()
            while queue:
                node, parent, depth = queue.pop(0)
                if node in visited:
                    if node == u:
                        min_cycle = min(min_cycle, depth)
                    continue
                visited.add(node)
                for v in graph[node]:
                    if v != parent:
                        queue.append((v, node, depth + 1))
        return min_cycle if min_cycle != float('inf') else -1