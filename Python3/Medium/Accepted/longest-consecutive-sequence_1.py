class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        nums = set(nums)
        res = 0
        for n in nums:
            if n-1 not in nums:
                curr = 1
                while n+1 in nums:
                    n += 1
                    curr += 1
                res = max(res, curr)
        return res