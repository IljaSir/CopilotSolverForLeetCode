class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        count = 0
        for i in range(1, len(nums) - 1):
            if nums[i] > nums[i - 1] and nums[i] > nums[i + 1]:
                count += 1
            elif nums[i] < nums[i - 1] and nums[i] < nums[i + 1]:
                count += 1
        return count