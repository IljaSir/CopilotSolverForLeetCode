class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        nums.sort()
        n = len(nums)
        mid = (n+1)//2
        nums[1::2], nums[::2] = nums[mid:], nums[:mid]