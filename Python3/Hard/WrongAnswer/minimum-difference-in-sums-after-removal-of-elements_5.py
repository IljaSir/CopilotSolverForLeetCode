class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        n = len(nums) // 3
        nums.sort()
        return min(nums[i+n-1] - nums[i] for i in range(n))