class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        
        n = len(nums)
        snums = sorted(nums)
        start = 0
        while start < n and nums[start] == snums[start]:
            start += 1
        end = n - 1
        while end >= 0 and nums[end] == snums[end]:
            end -= 1
        return 0 if end <= start else end - start + 1