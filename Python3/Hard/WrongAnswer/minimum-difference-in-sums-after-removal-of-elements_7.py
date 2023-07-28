class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums) // 3
        return min([nums[-1 - i] - nums[i] for i in range(n)])