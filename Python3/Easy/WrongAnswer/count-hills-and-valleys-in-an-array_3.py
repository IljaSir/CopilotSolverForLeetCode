class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        
        n = len(nums)
        hills = valleys = 0
        for i in range(1, n-1):
            if nums[i] > nums[i-1] and nums[i] > nums[i+1]:
                hills += 1
            elif nums[i] < nums[i-1] and nums[i] < nums[i+1]:
                valleys += 1
        return hills + valleys