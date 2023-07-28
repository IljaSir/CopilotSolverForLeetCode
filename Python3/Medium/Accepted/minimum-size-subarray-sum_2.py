class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        i = 0
        j = 0
        total = 0
        min_len = len(nums) + 1
        while j < len(nums):
            total += nums[j]
            while total >= target:
                min_len = min(min_len, j - i + 1)
                total -= nums[i]
                i += 1
            j += 1
        return min_len if min_len <= len(nums) else 0