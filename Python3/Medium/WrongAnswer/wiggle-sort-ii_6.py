class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        m = len(nums)
        if m < 2: return
        nums.sort()
        for i in range(1, m-1, 2):
            nums[i], nums[i+1] = nums[i+1], nums[i]