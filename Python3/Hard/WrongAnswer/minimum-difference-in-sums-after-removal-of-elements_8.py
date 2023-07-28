class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums) // 3
        return min([nums[-i-1]-nums[i] for i in range(n)])