class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            if nums[0] <= nums[1]:
                return 0
            else:
                return 2
        left = 0
        right = len(nums) - 1
        while left < len(nums) - 1 and nums[left] <= nums[left + 1]:
            left += 1
        while right > 0 and nums[right] >= nums[right - 1]:
            right -= 1
        if left >= right:
            return 0
        min_val = min(nums[left:right + 1])
        max_val = max(nums[left:right + 1])
        while left > 0 and nums[left - 1] > min_val:
            left -= 1
        while right < len(nums) - 1 and nums[right + 1] < max_val:
            right += 1
        return right - left + 1