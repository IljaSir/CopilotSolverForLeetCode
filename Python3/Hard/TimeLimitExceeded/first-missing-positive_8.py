class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        
        nums.sort()
        for i in range(1, len(nums)+2):
            if i not in nums:
                return i