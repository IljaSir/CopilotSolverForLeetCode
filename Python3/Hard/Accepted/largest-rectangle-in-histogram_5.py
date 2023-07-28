class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        if not heights:
            return 0
        stack = []
        heights.append(0)
        max_area = 0
        for i in range(len(heights)):
            while stack and heights[i] < heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i if not stack else i - stack[-1] - 1
                max_area = max(max_area, h * w)
            stack.append(i)
        return max_area