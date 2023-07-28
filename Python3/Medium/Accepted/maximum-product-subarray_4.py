class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        maxVal = nums[0]
        minVal = nums[0]
        res = nums[0]
        for i in range(1, len(nums)):
            if nums[i] < 0:
                maxVal, minVal = minVal, maxVal
            maxVal = max(nums[i], nums[i] * maxVal)
            minVal = min(nums[i], nums[i] * minVal)
            res = max(res, maxVal)
        return res