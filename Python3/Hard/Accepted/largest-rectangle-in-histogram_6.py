class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        stack = []
        res = 0
        for i, h in enumerate(heights):
            while stack and h < heights[stack[-1]]:
                j = stack.pop()
                res = max(res, heights[j] * (i - stack[-1] - 1 if stack else i))
            stack.append(i)
        while stack:
            j = stack.pop()
            res = max(res, heights[j] * (len(heights) - stack[-1] - 1 if stack else len(heights)))
        return res