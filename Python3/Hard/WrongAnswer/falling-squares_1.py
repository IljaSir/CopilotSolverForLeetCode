class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        
        ans = []
        for i, (left, side) in enumerate(positions):
            right = left + side
            h = side
            for j in range(i):
                l, s = positions[j]
                r = l + s
                if l < right and r > left:
                    h = max(h, side + ans[j])
            ans.append(h)
        return ans