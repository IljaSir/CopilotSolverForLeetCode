class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        
        nums.sort()
        for i in range(len(nums)):
            if nums[i] > value:
                return value
            value -= nums[i]
        return value