class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        
        nums.sort()
        i = 0
        j = 0
        count = 0
        while i < len(nums) and j < len(nums):
            if nums[i] * 2 <= nums[j]:
                count += 1
                i += 1
                j += 1
            else:
                j += 1
        return count