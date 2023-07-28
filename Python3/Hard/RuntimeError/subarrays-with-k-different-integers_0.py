class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        return self.atMostK(nums, k) - self.atMostK(nums, k-1)