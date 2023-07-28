class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return 1 if nums[0] >= target else 0
        left = 0
        right = 0
        curr_sum = 0length