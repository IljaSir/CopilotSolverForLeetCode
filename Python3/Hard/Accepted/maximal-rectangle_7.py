class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        
        if not matrix:
            return 0
        maxArea = 0
        height = [0] * (len(matrix[0]) + 1)
        for row in matrix:
            for i in range(len(matrix[0])):
                height[i] = height[i] + 1 if row[i] == '1' else 0
            stack = [-1]
            for i in range(len(matrix[0]) + 1):
                while height[i] < height[stack[-1]]:
                    h = height[stack.pop()]
                    w = i - stack[-1] - 1
                    maxArea = max(maxArea, h * w)
                stack.append(i)
        return maxArea