class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        # max_product = nums[0]
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)+1):
        #         product = 1
        #         for k in range(i,j):
        #             product *= nums[k]
        #         max_product = max(max_product, product)
        # return max_product
        max_product = nums[0]
        min_product = nums[0]
        ans = nums[0]
        for i in range(1, len(nums)):
            if nums[i] < 0:
                max_product, min_product = min_product, max_product
            max_product = max(nums[i], max_product*nums[i])
            min_product = min(nums[i], min_product*nums[i])
            ans = max(ans, max_product)
        return ans