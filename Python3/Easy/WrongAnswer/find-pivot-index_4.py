class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        
        # Solution 1: 20 ms (99.97%)
        # sum_left = 0
        # sum_right = sum(nums)
        # for i in range(len(nums)):
        #     sum_right -= nums[i]
        #     if sum_left == sum_right:
        #         return i
        #     sum_left += nums[i]
        # return -1
        # Solution 2: 24 ms (99.97%)
        # sum_left = 0
        # sum_right = sum(nums)
        # for i in range(len(nums)):
        #     if sum_left == sum_right - nums[i]:
        #         return i
        #     sum_left += nums[i]
        #     sum_right -= nums[i]
        # return -1
        # Solution 3: 32 ms (99.97%)
        # sum_left = 0
        # sum_right = sum(nums)
        # for i in range(len(nums)):
        #     if sum_left == sum_right - nums[i]:
        #         return i
        #     sum_left += nums[i]
        # return -1
        # Solution 4: 36 ms (99.97%)
        sum_left = 0
        sum_right = sum(nums)
        for i in range(len(nums)):
            if sum_left == sum_right - nums[i]:
                return i
            sum_left += nums[i]
        return -1