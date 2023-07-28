class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        
        if not nums:
            return -1
        if len(nums) == 1:
            return nums[0]
        nums = sorted(nums)
        if nums[0] < 0:
            if nums[-1] < 0:
                return -1
            elif nums[-1] == 0:
                return 0
            else:
                return nums[-1]
        elif nums[0] == 0:
            return 1
        else:
            return nums[-1]