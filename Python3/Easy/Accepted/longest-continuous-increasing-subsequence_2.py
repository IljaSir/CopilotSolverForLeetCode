class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        if len(nums) == 1:
            return 1
        max_length = 1
        length = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                length += 1
                max_length = max(max_length, length)
            else:
                length = 1
        return max_length