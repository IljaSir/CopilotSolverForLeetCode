class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        # 暴力解法
        # n = len(heights)
        # maxarea = 0
        # for i in range(n):
        #     left = i
        #     right = i
        #     while left - 1 >= 0 and heights[left - 1] >= heights[i]:
        #         left -= 1
        #     while right + 1 < n and heights[right + 1] >= heights[i]:
        #         right += 1
        #     maxarea = max(maxarea, (right - left + 1) * heights[i])
        # return maxarea
        # 单调栈
        # 1. 单调递增栈
        # 2. 用一个0元素来结束栈，方便处理最后一次计算
        # 3. 每次计算都是以当前元素为高度的矩形，所以要用当前元素的前一个元素来计算宽度
        n = len(heights)
        stack = [-1]
        maxarea = 0
        for i in range(n):
            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
                maxarea = max(maxarea, heights[stack.pop()] * (i - stack[-1] - 1))
            stack.append(i)
        while stack[-1] != -1:
            maxarea = max(maxarea, heights[stack.pop()] * (n - stack[-1] - 1))
        return maxarea