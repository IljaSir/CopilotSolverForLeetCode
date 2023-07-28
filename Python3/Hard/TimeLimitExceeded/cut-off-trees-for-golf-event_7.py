class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        
        # 1. find all trees
        # 2. find shortest path from start to each tree
        # 3. repeat
        # 4. return total steps
        def find_trees():
            trees = []
            for i in range(len(forest)):
                for j in range(len(forest[0])):
                    if forest[i][j] > 1:
                        trees.append((forest[i][j], i, j))
            return sorted(trees)
        
        def find_shortest_path(start, end):
            # BFS
            queue = [(start[0], start[1], 0)]
            visited = set()
            while queue:
                i, j, steps = queue.pop(0)
                if (i, j) == end:
                    return steps
                visited.add((i, j))
                for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < len(forest) and 0 <= nj < len(forest[0]) and forest[ni][nj] != 0 and (ni, nj) not in visited:
                        queue.append((ni, nj, steps+1))
            return -1
        
        trees = find_trees()
        start = (0, 0)
        total_steps = 0
        for tree in trees:
            steps = find_shortest_path(start, (tree[1], tree[2]))
            if steps == -1:
                return -1
            total_steps += steps
            start = (tree[1], tree[2])
        return total_steps