class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        nums.sort()
        nums = [i for i in nums if i != 0]
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        min_num = nums[0]
        operations = 0
        for i in range(len(nums)):
            if i == 0:
                operations += nums[i]
            else:
                operations += nums[i] - min_num
        return operations