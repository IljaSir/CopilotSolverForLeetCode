class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        n = len(nums)
        nums = [0] + nums + [0]
        res = 0
        for i in range(1, n + 1):
            if nums[i] <= nums[i - 1]:
                res += nums[i - 1] - nums[i] + 1
                nums[i] = nums[i - 1] + 1
            if nums[i] <= nums[i + 1]:
                res += nums[i + 1] - nums[i] + 1
                nums[i + 1] = nums[i] + 1
        return res