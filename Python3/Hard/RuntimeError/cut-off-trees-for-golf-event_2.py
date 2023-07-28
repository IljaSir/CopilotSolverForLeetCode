class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        
        m, n = len(forest), len(forest[0])
        trees = [(h, r, c) for r, row in enumerate(forest) for c, h in enumerate(row) if h > 1]
        trees.sort()
        sr, sc = 0, 0
        ans = 0
        for h, tr, tc in trees:
            steps = self.bfs(forest, sr, sc, tr, tc)
            if steps < 0:
                return -1
            ans += steps
            sr, sc = tr, tc
        return ans