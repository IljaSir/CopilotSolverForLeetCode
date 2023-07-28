class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        # Runtime: 136 ms, faster than 90.16% of Python3 online submissions for Continuous Subarray Sum.
        # Memory Usage: 16.2 MB, less than 5.33% of Python3 online submissions for Continuous Subarray Sum.
        if k == 0:
            for i in range(len(nums) - 1):
                if nums[i] == 0 and nums[i + 1] == 0:
                    return True
            return False
        if len(nums) < 2:
            return False
        # if k == 0:
        #     for i in range(len(nums) - 1):
        #         if nums[i] == 0 and nums[i + 1] == 0:
        #             return True
        #     return False
        # if len(nums) < 2:
        #     return False
        # if k == 0:
        #     for i in range(len(nums) - 1):
        #         if nums[i] == 0 and nums[i + 1] == 0:
        #             return True
        #     return False
        # if len(nums) < 2:
        #     return False
        # if k == 0:
        #     for i in range(len(nums) - 1):
        #         if nums[i] == 0 and nums[i + 1] == 0:
        #             return True
        #     return False
        # if len(nums) < 2:
        #     return False
        # if k == 0:
        #     for i in range(len(nums) - 1):
        #         if nums[i] == 0 and nums[i + 1] == 0:
        #             return True
        #     return False
        # if len(nums) < 2:
        #     return False
        # if k == 0:
        #     for i in range(len(nums) - 1):
        #         if nums[i] == 0 and nums[i + 1] == 0:
        #             return True
        #     return False
        # if len(nums) < 2:
        #     return False
        # if k == 0:
        #     for i in range(len(nums) - 1):
        #         if nums[i] ==