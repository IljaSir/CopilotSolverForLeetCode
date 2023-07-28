class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if not nums: return
        if len(nums) == 1: return
        for i in range(len(nums)-1, 0, -1):
            if nums[i] > nums[i-1]:
                for j in range(len(nums)-1, i-1, -1):
                    if nums[j] > nums[i-1]:
                        nums[i-1], nums[j] = nums[j], nums[i-1]
                        nums[i:] = sorted(nums[i:])
                        return
            if i == 1:
                nums.sort()
                return