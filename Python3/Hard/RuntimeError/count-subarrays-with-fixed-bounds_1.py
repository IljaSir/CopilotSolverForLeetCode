class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        
        return self.countSubarraysLessThanK(nums, maxK) - self.countSubarraysLessThanK(nums, minK - 1)