class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        
        if not nums:
            return -1
        nums.sort()
        if nums[0] > 0:
            return nums[-1]
        if nums[-1] < 0:
            return -nums[0]
        for i in range(len(nums)):
            if nums[i] > 0:
                return nums[i-1]
        return -1