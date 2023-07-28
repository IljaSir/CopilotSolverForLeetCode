class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        
        res = []
        stack = []
        for left, side in positions:
            right = left + side
            h = 0
            for l, r, h0 in stack:
                if left < r and right > l:
                    h = max(h, h0)
            h += side
            stack.append([left, right, h])
            res.append(max(res[-1] if res else 0, h))
        return res