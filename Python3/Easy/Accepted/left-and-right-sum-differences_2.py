class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        
        left_sum = [0] * len(nums)
        right_sum = [0] * len(nums)
        for i in range(1, len(nums)):
            left_sum[i] = left_sum[i - 1] + nums[i - 1]
            right_sum[len(nums) - i - 1] = right_sum[len(nums) - i] + nums[len(nums) - i]
        return [abs(left_sum[i] - right_sum[i]) for i in range(len(nums))]