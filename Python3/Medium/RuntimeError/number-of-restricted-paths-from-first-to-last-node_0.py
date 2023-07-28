class Solution:
    def countRestrictedPaths(self, n: int, edges: List[List[int]]) -> int:
        
        # Dijkstra's algorithm
        # Time  complexity: O((V + E) * log(V))
        # Space complexity: O(V + E)
        # from collections import defaultdict
        # from heapq import heappush, heappop
        # graph = defaultdict(list)
        # for u, v, w in edges:
        #     graph[u].append((v, w))
        #     graph[v].append((u, w))
        # dist = [float('inf')] * (n + 1)
        # dist[n] = 0
        # heap = [(0, n)]
        # while heap:
        #     d, node = heappop(heap)
        #     if d > dist[node]:
        #         continue
        #     for nei, w in graph[node]:
        #         if d + w < dist[nei]:
        #             dist[nei] = d + w
        #             heappush(heap, (dist[nei], nei))
        # @lru_cache(None)
        # def dfs(node):
        #     if node == n:
        #         return 1
        #     ans = 0
        #     for nei, w in graph[node]:
        #         if dist[nei] < dist[node]:
        #             ans += dfs(nei)
        #     return ans
        # return dfs(1) % (10**9 + 7)

        # Bellman-Ford algorithm
        # Time  complexity: O(V * E)
        # Space complexity: O(V + E)
        # from collections import defaultdict
        # graph = defaultdict(list)
        # for u, v, w in edges:
        #     graph[u].append((v, w))
        #     graph[v].append((u, w))
        # dist = [float('inf')] * (n + 1)
        # dist[n] = 0
        # for _ in range(n - 1):
        #     for u, v, w in edges:
        #         dist[v] = min(dist[v], dist[u] + w)
        #         dist[u] = min(dist[u], dist[v] + w)
        # @lru_cache(None)
        # def dfs(node):
        #     if node == n:
        #         return 1
        #     ans =