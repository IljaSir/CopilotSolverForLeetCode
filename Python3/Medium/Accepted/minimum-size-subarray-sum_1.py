class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        total = 0
        start = 0
        min_len = float('inf')
        for i, num in enumerate(nums):
            total += num
            while total >= target:
                min_len = min(min_len, i - start + 1)
                total -= nums[start]
                start += 1
        return min_len if min_len != float('inf') else 0