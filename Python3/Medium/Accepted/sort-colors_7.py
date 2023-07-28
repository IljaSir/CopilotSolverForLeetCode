class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # one pass algorithm
        # use two pointers to track the last 0 and first 2
        # when meet a 2, swap with the first 2
        # when meet a 0, swap with the last 0
        # when meet a 1, do nothing
        # use two pointers to track the last 0 and first 2
        last0 = 0
        first2 = len(nums) - 1
        
        # index to iterate the list
        i = 0
        
        # iterate the list
        while i <= first2:
            # if meet a 2, swap with the first 2
            if nums[i] == 2:
                nums[i], nums[first2] = nums[first2], nums[i]
                first2 -= 1
            # if meet a 0, swap with the last 0
            elif nums[i] == 0:
                nums[i], nums[last0] = nums[last0], nums[i]
                last0 += 1
                i += 1
            # if meet a 1, do nothing
            else:
                i += 1