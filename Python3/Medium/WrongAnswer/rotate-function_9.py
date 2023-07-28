class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        
        max_val = -float('inf')
        n = len(nums)
        for i in range(n):
            temp = sum([nums[j] * (j-i) for j in range(n)])
            max_val = max(max_val, temp)
        return max_val