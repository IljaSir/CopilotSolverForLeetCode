class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        start = 0
        end = len(nums) - 1
        while start < len(nums) - 1 and nums[start] <= nums[start + 1]:
            start += 1
        while end > 0 and nums[end] >= nums[end - 1]:
            end -= 1
        if start >= end:
            return 0
        min_val = min(nums[start:end + 1])
        max_val = max(nums[start:end + 1])
        while start >= 0 and nums[start] > min_val:
            start -= 1
        while end < len(nums) and nums[end] < max_val:
            end += 1
        return end - start - 1