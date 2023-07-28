class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        return self.findPeakElementHelper(nums, 0, len(nums)-1)