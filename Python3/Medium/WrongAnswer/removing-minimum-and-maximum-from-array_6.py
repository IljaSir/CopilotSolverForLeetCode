class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        return min(nums.index(min(nums)), len(nums)-1-nums[::-1].index(max(nums)))