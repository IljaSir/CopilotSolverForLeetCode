class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        increasing = nums[0] <= nums[1]
        for i in range(1, len(nums) - 1):
            if increasing:
                if nums[i] > nums[i + 1]:
                    return False
            else:
                if nums[i] < nums[i + 1]:
                    return False
        return True