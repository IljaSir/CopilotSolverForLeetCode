class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        nums = set(nums)
        max_len = 0
        for n in nums:
            if n-1 not in nums:
                curr = n
                while curr in nums:
                    curr += 1
                max_len = max(max_len, curr - n)
        return max_len