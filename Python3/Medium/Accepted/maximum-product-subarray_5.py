class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        max_product = nums[0]
        prev_max = nums[0]
        prev_min = nums[0]
        for i in range(1, len(nums)):
            curr_max = max(nums[i], prev_max * nums[i], prev_min * nums[i])
            curr_min = min(nums[i], prev_max * nums[i], prev_min * nums[i])
            max_product = max(max_product, curr_max)
            prev_max = curr_max
            prev_min = curr_min
        return max_product