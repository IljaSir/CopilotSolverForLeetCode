class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        
        # # BFS
        # # Time  complexity: O(V + E)
        # # Space complexity: O(V + E)
        # graph = collections.defaultdict(list)
        # for u, v in redEdges: graph[u].append((v, 0))
        # for u, v in blueEdges: graph[u].append((v, 1))
        # q = collections.deque([(0, -1, 0)])
        # seen = {(0, -1)}
        # ans = [-1] * n
        # while q:
        #     node, color, dist = q.popleft()
        #     if ans[node] == -1: ans[node] = dist
        #     for nei, nei_color in graph[node]:
        #         if (nei, nei_color) not in seen and nei_color != color:
        #             seen.add((nei, nei_color))
        #             q.append((nei, nei_color, dist + 1))
        # return ans

        # Dijkstra's Algorithm
        # Time  complexity: O(V log V + E)
        # Space complexity: O(V + E)
        graph = collections.defaultdict(list)
        for u, v in redEdges: graph[u].append((v, 0))
        for u, v in blueEdges: graph[u].append((v, 1))
        pq = [(0, 0, -1)]
        ans = [-1] * n
        while pq:
            dist, node, color = heapq.heappop(pq)
            if ans[node] == -1:
                ans[node] = dist
                for nei, nei_color in graph[node]:
                    if nei_color != color:
                        heapq.heappush(pq, (dist + 1, nei, nei_color))
        return ans