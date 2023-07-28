class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return nums[0] if nums[0] > 0 else nums[1]
        if nums[0] >= 0:
            return nums[0]
        if nums[-1] <= 0:
            return nums[-1]

        for i in range(n - 1):
            if nums[i] <= 0 and nums[i + 1] >= 0:
                return nums[i] if abs(nums[i]) < abs(nums[i + 1]) else nums[i + 1]