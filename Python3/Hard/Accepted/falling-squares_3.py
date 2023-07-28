class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        
        ans = []
        heights = []
        for pos in positions:
            left, side = pos[0], pos[1]
            right = left + side
            height = side
            for i in range(len(heights)):
                if left < heights[i][1] and heights[i][0] < right:
                    height = max(height, heights[i][2] + side)
            heights.append([left, right, height])
            ans.append(max(ans[-1] if ans else 0, height))
        return ans