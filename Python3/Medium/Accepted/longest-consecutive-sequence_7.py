class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        nums = set(nums)
        max_len = 1
        for num in nums:
            if num - 1 not in nums:
                curr = num
                curr_len = 1
                while curr + 1 in nums:
                    curr += 1
                    curr_len += 1
                max_len = max(max_len, curr_len)
        return max_len