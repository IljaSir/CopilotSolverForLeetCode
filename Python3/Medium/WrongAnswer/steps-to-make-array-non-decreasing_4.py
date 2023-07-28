class Solution:
    def totalSteps(self, nums: List[int]) -> int:
        
        nums1 = sorted(nums)
        return sum([abs(nums[i] - nums1[i]) for i in range(len(nums))])