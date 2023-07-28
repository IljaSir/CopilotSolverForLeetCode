class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        # brute force
        # area = 0
        # for i in range(len(heights)):
        #     left = i
        #     right = i
        #     while left > 0 and heights[left-1] >= heights[i]:
        #         left -= 1
        #     while right < len(heights)-1 and heights[right+1] >= heights[i]:
        #         right += 1
        #     area = max(area, (right-left+1)*heights[i])
        # return area
        
        # stack
        area = 0
        stack = []
        for i in range(len(heights)):
            while stack and heights[stack[-1]] > heights[i]:
                h = heights[stack.pop()]
                w = i if not stack else i-stack[-1]-1
                area = max(area, h*w)
            stack.append(i)
        while stack:
            h = heights[stack.pop()]
            w = len(heights) if not stack else len(heights)-stack[-1]-1
            area = max(area, h*w)
        return area