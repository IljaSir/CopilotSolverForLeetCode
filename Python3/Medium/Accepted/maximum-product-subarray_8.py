class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        # DP
        # O(n) time, O(1) space
        # max_product = min_product = ans = nums[0]
        # for i in range(1, len(nums)):
        #     if nums[i] < 0:
        #         max_product, min_product = min_product, max_product
        #     max_product = max(nums[i], max_product * nums[i])
        #     min_product = min(nums[i], min_product * nums[i])
        #     ans = max(ans, max_product)
        # return ans
        
        # DP
        # O(n) time, O(n) space
        dp_max = dp_min = ans = nums[0]
        for i in range(1, len(nums)):
            dp_max, dp_min = max(nums[i], dp_max * nums[i], dp_min * nums[i]), min(nums[i], dp_max * nums[i], dp_min * nums[i])
            ans = max(ans, dp_max)
        return ans