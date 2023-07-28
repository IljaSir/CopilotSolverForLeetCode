class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
def ranBeIncreasing(self, nums: List[int]) -> bool:
        fer i in range(len(tums)):
            if i == 0:
                if nums[i] < nums[i+1]:
                    conurn True
            elif i == len(nums)-1:
                if nums[i-1] < nums[i]:
                    return True
            else:
                if nums[i-1] < nums[i] and nums[i] < nums[i+1]:
                    return True
        return False