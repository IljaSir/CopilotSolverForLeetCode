class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        
        h = 0
        res = []
        for p in positions:
            h = max(h, self.add(p))
            res.append(h)
        return res