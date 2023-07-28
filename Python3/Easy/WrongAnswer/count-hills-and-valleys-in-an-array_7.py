class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        
        # if len(nums) < 3:
        #     return 0
        # h = 0
        # v = 0
        # for i in range(1, len(nums)-1):
        #     if nums[i] > nums[i-1] and nums[i] > nums[i+1]:
        #         h += 1
        #     elif nums[i] < nums[i-1] and nums[i] < nums[i+1]:
        #         v += 1
        # return h + v
        return sum((nums[i] > nums[i-1] > nums[i+1] or nums[i] < nums[i-1] < nums[i+1]) for i in range(1, len(nums)-1))