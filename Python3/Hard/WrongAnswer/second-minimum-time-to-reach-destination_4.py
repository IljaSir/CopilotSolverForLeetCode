class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], time: int, change: int) -> int:
        
        # BFS
        # Time  complexity: O(N+E)
        # Space complexity: O(N+E)
        adj = [[] for _ in range(n+1)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        queue = collections.deque([(1, 0)])
        seen = {1: 0}
        while queue:
            node, elapsed = queue.popleft()
            for nei in adj[node]:
                t = (elapsed + time) // change * change + change
                if t <= elapsed + time: t += change
                if nei not in seen or seen[nei] > t:
                    seen[nei] = t
                    queue.append((nei, t))
        return seen[n]