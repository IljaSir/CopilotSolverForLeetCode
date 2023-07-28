class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], time: int, change: int) -> int:
        
        
        # Dijkstra's algorithm
        # https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
        # https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
        # https://leetcode.com/problems/second-minimum-time-to-reach-destination/discuss/1037517/Python-Dijkstra's-Algorithm-with-Explanation
        
        # build graph
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append((time, v))
            graph[v].append((time, u))
        
        # initialize heap
        h = [(0, 1)]
        seen = set()
        while h:
            t, u = heapq.heappop(h)
            if u == n:
                return t
            if u in seen:
                continue
            seen.add(u)
            for t2, v in graph[u]:
                # change the signal
                if t % change < change - t2:
                    t += change - t % change
                heapq.heappush(h, (t + t2, v))
        
        return -1