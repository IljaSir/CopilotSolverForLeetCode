class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        total = sum(nums)
        n = len(nums)
        curr = sum([i * nums[i] for i in range(n)])
        max_val = curr
        for i in range(n-1, 0, -1):
            curr = curr + total - n * nums[i]
            max_val = max(max_val, curr)
        return max_val