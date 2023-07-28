class Solution:
    def minDifference(self, nums: List[int]) -> int:
        
        if len(nums) <= 4:
            return 0
        nums.sort()
        return min(b - a for a, b in zip(nums[:4], nums[-4:]))