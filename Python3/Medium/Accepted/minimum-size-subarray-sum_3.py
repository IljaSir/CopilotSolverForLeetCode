class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        i = 0
        j = 0
        sum = 0
        min_len = float('inf')
        while j < len(nums):
            sum += nums[j]
            while sum >= target:
                min_len = min(min_len, j - i + 1)
                sum -= nums[i]
                i += 1
            j += 1
        return min_len if min_len != float('inf') else 0