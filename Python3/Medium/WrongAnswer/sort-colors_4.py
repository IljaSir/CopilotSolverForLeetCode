class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        l = len(nums)
        i = j = k = 0
        for i in range(l):
            if nums[i] == 0:
                nums[i], nums[k] = nums[k], nums[i]
                if k > j:
                    nums[i], nums[j] = nums[j], nums[i]
                k += 1
                j += 1
            elif nums[i] == 1:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
            else:
                pass