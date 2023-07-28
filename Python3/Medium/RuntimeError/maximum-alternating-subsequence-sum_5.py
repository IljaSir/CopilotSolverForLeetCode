class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        # Solution 1: DP
        # DP[i] = max(DP[i-1], DP[i-2] + nums[i])
        # O(n) time, O(1) space
        # if len(nums) == 1:
        #     return nums[0]
        # dp1 = nums[0]
        # dp2 = max(nums[0], nums[1])
        # for i in range(2, len(nums)):
        #     dp1, dp2 = dp2, max(dp2, dp1 + nums[i])
        # return dp2

        # Solution 2: DP (optimized)
        # O(n) time, O(1) space
        # if len(nums) == 1:
        #     return nums[0]
        # dp = max(nums[0], nums[1])
        # for i in range(2, len(nums)):
        #     dp = max(dp, dp - nums[i-1] + nums[i])
        # return dp

        # Solution 3: DP (optimized)
        # O(n) time, O(1) space
        # if len(nums) == 1:
        #     return nums[0]
        # dp = max(nums[0], nums[1])
        # for i in range(2, len(nums)):
        #     if nums[i] > nums[i-1]:
        #         dp += nums[i] - nums[i-1]
        # return dp

        # Solution 4: DP (optimized)
        # O(n) time, O(1) space
        # if len(nums) == 1:
        #     return nums[0]
        # dp = nums[0]
        # for i in range(1, len(nums)):
        #     dp += max(nums[i] - nums[i-1], 0)
        # return dp

        # Solution 5: DP (optimized)
        # O(n) time, O(1) space
        # if len(nums) == 1:
        #     return nums[0]
        # dp = nums[0]
        # for i in range(1, len(nums)):
        #     dp += max(nums[i] - nums[i-1], 0)
        # return dp

        # Solution 6: DP (optimized)
        # O(n) time, O(