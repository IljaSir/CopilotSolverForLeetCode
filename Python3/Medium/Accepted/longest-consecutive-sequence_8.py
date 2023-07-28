class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        nums = set(nums)
        longest = 0
        for n in nums:
            if n-1 not in nums:
                current = n
                current_length = 1
                while current + 1 in nums:
                    current += 1
                    current_length += 1
                longest = max(longest, current_length)
        return longest