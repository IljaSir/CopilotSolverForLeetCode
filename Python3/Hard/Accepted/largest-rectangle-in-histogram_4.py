class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        stack = []
        max_area = 0
        heights.append(0)
        for i, h in enumerate(heights):
            if not stack or h >= heights[stack[-1]]:
                stack.append(i)
            else:
                while stack and h < heights[stack[-1]]:
                    idx = stack.pop()
                    if stack:
                        max_area = max(max_area, heights[idx] * (i - stack[-1] - 1))
                    else:
                        max_area = max(max_area, heights[idx] * i)
                stack.append(i)
        return max_area