class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
        for i in range(len(nums)):
            if nums[i-1] >= nums[i]:
                if i == 1 or i == len(nums)-1 or nums[i-2] < nums[i]:
                    nums.pop(i)
                else:
                    nums.pop(i-1)
                break
        for i in range(1, len(nums)):
            if nums[i-1] >= nums[i]:
                return False
        return True