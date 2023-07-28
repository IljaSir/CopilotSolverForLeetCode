class Solution:
    def trap(self, height: List[int]) -> int:
        
        if len(height) < 3:
            return 0
        left = 0
        right = len(height) - 1
        left_max = height[left]
        right_max = height[right]
        ans = 0
        while left < right:
            if height[left] < height[right]:
                left += 1
                left_max = max(left_max, height[left])
                ans += left_max - height[left]
            else:
                right -= 1
                right_max = max(right_max, height[right])
                ans += right_max - height[right]
        return ans