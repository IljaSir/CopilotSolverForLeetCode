class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        nums.sort()
        res = 0
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                res += i * (nums[i] - nums[i-1])
        return res