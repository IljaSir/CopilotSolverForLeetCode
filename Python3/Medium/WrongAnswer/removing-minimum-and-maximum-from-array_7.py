class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 1
        min_deletions = len(nums) - 1
        for i in range(1, len(nums)):
            min_deletions = min(min_deletions, i + len(nums) - 1 - bisect.bisect_right(nums, nums[i], hi=len(nums) - 1))
        return min_deletions