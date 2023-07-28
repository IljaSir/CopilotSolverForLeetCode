class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        graph = collections.defaultdict(dict)
        for u, v, w in times:
            graph[u][v] = w
        dist = {node: float('inf') for node in range(1, n+1)}
        dist[k] = 0
        seen = [False] * (n+1)
        while True:
            cand_node = -1
            cand_dist = float('inf')
            for i in range(1, n+1):
                if not seen[i] and dist[i] < cand_dist:
                    cand_dist = dist[i]
                    cand_node = i
            if cand_node < 0: break
            seen[cand_node] = True
            for nei, d in graph[cand_node].items():
                dist[nei] = min(dist[nei], dist[cand_node] + d)
        ans = max(dist.values())
        return ans if ans < float('inf') else -1