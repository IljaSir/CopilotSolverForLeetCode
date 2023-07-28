class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        
        m, n = len(forest), len(forest[0])
        trees = sorted((v, r, c) for r, row in enumerate(forest) for c, v in enumerate(row) if v > 1)
        sr, sc = 0, 0
        ans = 0
        for _, tr, tc in trees:
            d = self.bfs(forest, sr, sc, tr, tc)
            if d < 0: return -1
            ans += d
            sr, sc = tr, tc
        return ans