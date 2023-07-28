class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        # nums.sort()
        # for i in range(len(nums)):
        #     if nums[i] != 0:
        #         nums = nums[i:]
        #         break
        # nums = [i for i in nums if i != 0]
        nums = [i for i in nums if i != 0]
        nums.sort()
        count = 0
        while len(nums) > 0:
            if len(nums) == 1:
                count += nums[0]
                break
            nums = [i-nums[0] for i in nums]
            count += nums[0]
            nums = [i for i in nums if i != 0]
            nums.sort()
        return count