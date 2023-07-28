class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        if k == 1:
            return nums
        return [max(nums[i:i+k]) for i in range(len(nums)-k+1)]