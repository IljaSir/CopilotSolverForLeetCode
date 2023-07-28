class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        
        res = []
        height = 0
        for left, size in positions:
            right = left + size
            h = 0
            for l, r, h in res:
                if left < r and right > l:
                    h = max(h, h)
            h += size
            res.append([left, right, h])
            height = max(height, h)
            res.append(height)
        return res