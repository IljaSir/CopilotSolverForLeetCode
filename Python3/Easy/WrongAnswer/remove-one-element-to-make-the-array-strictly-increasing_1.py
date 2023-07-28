class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
        n = len(nums)
        for i in range(n):
            if i == 0 or nums[i] > nums[i-1]:
                continue
            if i == 1 or nums[i] > nums[i-2]:
                nums[i-1] = nums[i]
            else:
                nums[i] = nums[i-1]
            break
        for i in range(1, n):
            if nums[i] <= nums[i-1]:
                return False
        return True