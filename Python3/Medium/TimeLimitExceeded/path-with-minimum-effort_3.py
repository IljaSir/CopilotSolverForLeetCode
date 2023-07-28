class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        # dijkstra's algorithm
        # initialize
        m, n = len(heights), len(heights[0])
        dist = [[float('inf')] * n for _ in range(m)]
        dist[0][0] = 0
        visited = [[False] * n for _ in range(m)]
        # helper function
        def get_neighbors(i, j):
            neighbors = []
            if i > 0:
                neighbors.append((i - 1, j))
            if i < m - 1:
                neighbors.append((i + 1, j))
            if j > 0:
                neighbors.append((i, j - 1))
            if j < n - 1:
                neighbors.append((i, j + 1))
            return neighbors
        # dijkstra's algorithm
        while True:
            # find the next node to visit
            min_dist = float('inf')
            min_i, min_j = -1, -1
            for i in range(m):
                for j in range(n):
                    if not visited[i][j] and dist[i][j] < min_dist:
                        min_dist = dist[i][j]
                        min_i, min_j = i, j
            # check if we are done
            if min_i == -1 and min_j == -1:
                break
            # update the distance to all neighbors
            for i, j in get_neighbors(min_i, min_j):
                dist[i][j] = min(dist[i][j], max(dist[min_i][min_j], abs(heights[min_i][min_j] - heights[i][j])))
            # mark as visited
            visited[min_i][min_j] = True
        return dist[-1][-1]