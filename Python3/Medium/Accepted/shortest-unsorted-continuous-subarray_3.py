class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        sorted_nums = sorted(nums)
        if nums == sorted_nums:
            return 0
        i, j = 0, len(nums) - 1
        while i < j:
            if nums[i] == sorted_nums[i]:
                i += 1
            if nums[j] == sorted_nums[j]:
                j -= 1
            if nums[i] != sorted_nums[i] and nums[j] != sorted_nums[j]:
                break
        return j - i + 1