class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        if len(nums) <= 1:
            return len(nums)
        nums = set(nums)
        longest = 0
        for num in nums:
            if num - 1 not in nums:
                current = num
                current_length = 1
                while current + 1 in nums:
                    current += 1
                    current_length += 1
                longest = max(longest, current_length)
        return longest