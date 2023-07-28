class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        n = len(nums) // 3
        nums.sort()
        res = float('inf')
        for i in range(n):
            res = min(res, nums[-i-1] - nums[i])
            res = min(res, nums[-i-1-n] - nums[i+n])
        return res