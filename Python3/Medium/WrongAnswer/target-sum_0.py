class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        if not nums:
            return 0
        if len(nums) == 1:
            if nums[0] == target:
                return 2
            else:
                return 0
        return self.findTargetSumWays(nums[1:], target - nums[0]) + self.findTargetSumWays(nums[1:], target + nums[0])