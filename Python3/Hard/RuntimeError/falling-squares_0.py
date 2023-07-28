class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        
        heights = [0]
        for left, side in positions:
            right = left + side
            i, j = bisect.bisect_left(heights, left), bisect.bisect_right(heights, right)
            h = max(heights[i:j]) + side
            heights[i:j] = [h] * (j - i + 1)
            heights.append(0)
            heights[i + 1] = h
        return heights