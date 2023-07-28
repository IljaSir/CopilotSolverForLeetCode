class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        
        # Solution 1: Sort
        # return sorted(nums, key=lambda x: x % 2)
        # Solution 2: Two Pointers
        # left, right = 0, len(nums) - 1
        # while left < right:
        #     if nums[left] % 2 == 1 and nums[right] % 2 == 0:
        #         nums[left], nums[right] = nums[right], nums[left]
        #         left += 1
        #         right -= 1
        #     elif nums[left] % 2 == 0:
        #         left += 1
        #     elif nums[right] % 2 == 1:
        #         right -= 1
        # return nums
        # Solution 3: Two Pointers
        left, right = 0, 0
        while right < len(nums):
            if nums[right] % 2 == 0:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
            right += 1
        return nums