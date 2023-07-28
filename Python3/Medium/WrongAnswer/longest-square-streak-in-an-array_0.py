class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        
        nums = sorted(nums)
        if nums[0] * nums[0] != nums[1]:
            return -1
        max_len = 2
        current_len = 2
        for i in range(2, len(nums)):
            if nums[i] == nums[i - 1] * nums[i - 1]:
                current_len += 1
                max_len = max(max_len, current_len)
            else:
                current_len = 2
        return max_len