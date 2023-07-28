class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        res = 0
        diff = nums[1] - nums[0]
        start = 0
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == diff:
                continue
            if i - start >= 3:
                res += (i - start - 1) * (i - start - 2) // 2
            start = i - 1
            diff = nums[i] - nums[i-1]
        if len(nums) - start >= 3:
            res += (len(nums) - start - 1) * (len(nums) - start - 2) // 2
        return res