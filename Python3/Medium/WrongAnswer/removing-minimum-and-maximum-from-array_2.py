class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        n = len(nums)
        left = [0] * n
        right = [0] * n
        for i in range(1, n):
            left[i] = max(left[i - 1], nums[i - 1])
        for i in range(n - 2, -1, -1):
            right[i] = min(right[i + 1], nums[i + 1])
        ans = n
        for i in range(n):
            if left[i] < nums[i] < right[i]:
                ans = min(ans, i + n - 1 - i - 1)
        return ans