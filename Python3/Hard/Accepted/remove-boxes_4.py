class Solution:
    def removeBoxes(self, boxes: List[int]) -> int:
        
        @lru_cache(None)
        def dfs(i, j, k):
            if i > j: return 0
            while i < j and boxes[i] == boxes[i+1]:
                i, k = i + 1, k + 1
            res = (k+1)**2 + dfs(i+1, j, 0)
            for m in range(i+1, j+1):
                if boxes[i] == boxes[m]:
                    res = max(res, dfs(i+1, m-1, 0) + dfs(m, j, k+1))
            return res
        return dfs(0, len(boxes) - 1, 0)