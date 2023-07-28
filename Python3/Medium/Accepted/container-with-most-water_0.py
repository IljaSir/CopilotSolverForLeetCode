class Solution:
    def maxArea(self, height: List[int]) -> int:
        
        i, j, res = 0, len(height) - 1, 0
        while i < j:
            res = max(res, (j - i) * min(height[i], height[j]))
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return res