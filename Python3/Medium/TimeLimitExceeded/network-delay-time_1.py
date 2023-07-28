class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        graph = collections.defaultdict(list)
        for u, v, w in times:
            graph[u].append((v, w))
        dist = {node: float('inf') for node in range(1, n+1)}
        
        def dfs(node, elapsed):
            if elapsed >= dist[node]:
                return
            dist[node] = elapsed
            for v, w in sorted(graph[node]):
                dfs(v, elapsed + w)
        
        dfs(k, 0)
        ans = max(dist.values())
        return ans if ans < float('inf') else -1