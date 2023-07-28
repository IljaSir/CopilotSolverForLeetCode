class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        i = 0
        j = len(nums) - 1
        while i < j:
            m = i + (j - i) // 2
            if nums[m] < 0:
                i = m + 1
            else:
                j = m
        if i == 0:
            return nums[0]
        if i == len(nums):
            return nums[-1]
        if abs(nums[i] - 0) < abs(nums[i - 1] - 0):
            return nums[i]
        return nums[i - 1]