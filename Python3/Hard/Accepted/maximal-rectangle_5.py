class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        
        if not matrix or not matrix[0]:
            return 0
        m, n = len(matrix), len(matrix[0])
        height = [0] * (n + 1)
        res = 0
        for i in range(m):
            for j in range(n):
                height[j] = height[j] + 1 if matrix[i][j] == '1' else 0
            stack = [-1]
            for k in range(n + 1):
                while height[k] < height[stack[-1]]:
                    h = height[stack.pop()]
                    w = k - stack[-1] - 1
                    res = max(res, h * w)
                stack.append(k)
        return res