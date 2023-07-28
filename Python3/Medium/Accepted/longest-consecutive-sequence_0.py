class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        nums = set(nums)
        count = 0
        for i in nums:
            if i-1 not in nums:
                j = i
                while j in nums:
                    j += 1
                count = max(count, j-i)
        return count