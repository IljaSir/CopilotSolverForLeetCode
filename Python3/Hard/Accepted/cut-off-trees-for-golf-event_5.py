class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        
        def bfs(forest, start, target):
            m, n = len(forest), len(forest[0])
            queue = collections.deque([(start, 0)])
            visited = set()
            while queue:
                (x, y), d = queue.popleft()
                if (x, y) == target:
                    return d
                for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and forest[nx][ny] and (nx, ny) not in visited:
                        visited.add((nx, ny))
                        queue.append(((nx, ny), d + 1))
            return -1
        
        trees = []
        for i in range(len(forest)):
            for j in range(len(forest[i])):
                if forest[i][j] > 1:
                    trees.append((forest[i][j], i, j))
        trees.sort()
        start = (0, 0)
        ans = 0
        for _, x, y in trees:
            d = bfs(forest, start, (x, y))
            if d < 0:
                return -1
            ans += d
            start = (x, y)
        return ans