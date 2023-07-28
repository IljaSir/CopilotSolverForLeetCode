class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        
        nums.sort()
        for i in range(len(nums)):
            if value >= 0:
                nums[i] += value
                value -= value
            else:
                nums[i] -= value
                value += value
        nums.sort()
        if nums[0] > 0:
            return nums[0]
        for i in range(len(nums)-1):
            if nums[i+1] - nums[i] > 1:
                return nums[i] + 1
        return nums[-1] + 1