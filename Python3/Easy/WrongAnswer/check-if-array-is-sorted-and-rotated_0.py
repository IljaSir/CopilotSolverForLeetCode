class Solution:
    def check(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        if len(nums) == 2:
            return nums[0] <= nums[1]
        if len(nums) == 3:
            return nums[0] <= nums[1] and nums[1] <= nums[2]
        if len(nums) == 4:
            return nums[0] <= nums[1] and nums[1] <= nums[2] and nums[2] <= nums[3]
        # print(nums)
        for i in range(1, len(nums)):
            # print(nums[i-1], nums[i])
            if nums[i-1] > nums[i]:
                return False
        return True