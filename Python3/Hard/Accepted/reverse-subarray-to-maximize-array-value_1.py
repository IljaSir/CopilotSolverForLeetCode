class Solution:
    def maxValueAfterReverse(self, nums: List[int]) -> int:
        
        n = len(nums)
        res, minn, maxx = 0, float('inf'), -float('inf')
        for i in range(1, n):
            res += abs(nums[i] - nums[i - 1])
            minn = min(minn, max(nums[i], nums[i - 1]))
            maxx = max(maxx, min(nums[i], nums[i - 1]))
        res2 = 2 * (maxx - minn)
        for i in range(1, n):
            res2 = max(res2, abs(nums[0] - nums[i]) - abs(nums[i] - nums[i - 1]))
            res2 = max(res2, abs(nums[-1] - nums[i - 1]) - abs(nums[i] - nums[i - 1]))
        return res + res2