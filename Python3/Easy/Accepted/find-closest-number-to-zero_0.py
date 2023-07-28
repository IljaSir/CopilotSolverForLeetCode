class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        for i in range(len(nums)):
            if nums[i] >= 0:
                return nums[i-1] if abs(nums[i-1]) < abs(nums[i]) else nums[i]
        return nums[-1]