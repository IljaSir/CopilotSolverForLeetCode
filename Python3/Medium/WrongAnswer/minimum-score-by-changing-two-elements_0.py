class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        return min(nums[-1] - nums[1], nums[-2] - nums[0])