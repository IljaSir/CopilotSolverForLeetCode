class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        
        def bfs(start, end):
            queue = [start]
            visited = set()
            visited.add(start)
            steps = 0
            while queue:
                size = len(queue)
                for _ in range(size):
                    x, y = queue.pop(0)
                    if (x, y) == end:
                        return steps
                    for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                        nx, ny = x + dx, y + dy
                        if 0 <= nx < m and 0 <= ny < n and forest[nx][ny] != 0 and (nx, ny) not in visited:
                            queue.append((nx, ny))
                            visited.add((nx, ny))
                steps += 1
            return -1
        m, n = len(forest), len(forest[0])
        trees = []
        for i in range(m):
            for j in range(n):
                if forest[i][j] > 1:
                    trees.append((forest[i][j], i, j))
        trees.sort()
        start = (0, 0)
        steps = 0
        for tree in trees:
            height, x, y = tree
            step = bfs(start, (x, y))
            if step == -1:
                return -1
            steps += step
            start = (x, y)
        return steps