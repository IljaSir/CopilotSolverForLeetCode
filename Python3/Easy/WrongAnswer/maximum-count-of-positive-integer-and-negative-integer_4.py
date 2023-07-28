class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        
        max_count = 0
        count = 0
        for i, num in enumerate(nums):
            if num >= 0:
                count += 1
            else:
                count = 0
            max_count = max(max_count, count)
        return max_count