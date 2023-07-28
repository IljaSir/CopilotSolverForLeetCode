class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        if not nums:
            return 0
        total = 0
        j = 0
        min_len = len(nums) + 1
        for i in range(len(nums)):
            total += nums[i]
            while total >= target:
                min_len = min(min_len, i - j + 1)
                total -= nums[j]
                j += 1
        return min_len if min_len <= len(nums) else 0