class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            if nums[0] == 1:
                return 1
            else:
                return -1
        nums.sort()
        if nums[0] == 1:
            return 1
        if nums[0] > 1:
            return -1
        if nums[0] == -1:
            if nums[1] > 1:
                return -1
            elif nums[1] == 1:
                return 1
            else:
                return -1
        if nums[0] < -1:
            if nums[1] > 1:
                return -1
            elif nums[1] == 1:
                return 1
            else:
                return -1
        if nums[0] == 0:
            if nums[1] > 1:
                return -1
            elif nums[1] == 1:
                return 1
            else:
                return -1
        return -1