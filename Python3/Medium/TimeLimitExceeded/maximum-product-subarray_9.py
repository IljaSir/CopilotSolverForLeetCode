class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        maxs = min(nums)
        for i in range(0, len(nums)):
            tmp = 1
            for j in range(i, len(nums)):
                tmp *= nums[j]
                if tmp > maxs:
                    maxs = tmp
        return maxs