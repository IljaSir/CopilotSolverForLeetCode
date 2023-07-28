class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        sorted_nums = sorted(nums)
        start = -1
        end = -1
        for i in range(len(nums)):
            if nums[i] != sorted_nums[i]:
                if start == -1:
                    start = i
                end = i
        return end - start + 1