class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        max_prod = nums[0]
        min_prod = nums[0]
        res = nums[0]
        for i in range(1, len(nums)):
            max_prod, min_prod = max(nums[i], max_prod*nums[i], min_prod*nums[i]), min(nums[i], max_prod*nums[i], min_prod*nums[i])
            res = max(max_prod, res)
        return res