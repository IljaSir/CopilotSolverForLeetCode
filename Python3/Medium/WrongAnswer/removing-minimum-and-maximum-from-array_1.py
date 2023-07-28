class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        return min(nums.index(min(nums)), len(nums) - nums[::-1].index(max(nums))) + min(nums[::-1].index(min(nums)), len(nums) - nums.index(max(nums)))