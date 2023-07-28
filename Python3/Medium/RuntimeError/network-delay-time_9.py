class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        # Dijkstra's algorithm
        # 1. Initialize dist to infinity
        # 2. Initialize dist[k] to 0
        # 3. Repeat until all nodes are visited:
        #    a. Find node with smallest dist
        #    b. Iterate through all neighbors and update dist
        #    c. Mark node as visited
        # 4. Return max(dist)
        dist = [float('inf') for _ in range(n)]
        dist[k-1] = 0
        visited = [False for _ in range(n)]
        while not all(visited):
            # find node with smallest dist
            min_dist = float('inf')
            min_node = None
            for i in range(n):
                if not visited[i] and dist[i] < min_dist:
                    min_dist = dist[i]
                    min_node = i
            # iterate through all neighbors and update dist
            for time in times:
                if time[0] == min_node+1:
                    dist[time[1]-1] = min(dist[time[1]-1], dist[time[0]-1] + time[2])
            # mark node as visited
            visited[min_node] = True
        # return max(dist)
        max_dist = max(dist)
        return max_dist if max_dist != float('inf') else -1