class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        max_area = 0
        heights.append(0)
        stack = [-1]
        for i, height in enumerate(heights):
            while height < heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1
                max_area = max(max_area, h * w)
            stack.append(i)
        return max_area