class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        snums = sorted(nums)
        i = 0
        while i < len(nums):
            if nums[i] != snums[i]:
                break
            i += 1
        j = len(nums) - 1
        while j > 0:
            if nums[j] != snums[j]:
                break
            j -= 1
        if i >= j:
            return 0
        return j - i + 1