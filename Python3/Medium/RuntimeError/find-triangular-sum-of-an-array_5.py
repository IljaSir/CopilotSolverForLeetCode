class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        
        while len(nums) > 1:
            nums = [sum(divmod(x, 10)) for x in zip(nums, nums[1:])]
        return nums[0]