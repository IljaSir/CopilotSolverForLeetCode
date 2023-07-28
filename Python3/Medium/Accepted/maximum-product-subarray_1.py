class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        max_product = nums[0]
        min_product = nums[0]
        result = nums[0]
        for i in range(1, len(nums)):
            temp_max = max(nums[i], max_product*nums[i], min_product*nums[i])
            min_product = min(nums[i], max_product*nums[i], min_product*nums[i])
            max_product = temp_max
            result = max(result, max_product)
        return result