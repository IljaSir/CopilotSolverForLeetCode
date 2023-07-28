class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        nums = set(nums)
        res = 1
        for n in nums:
            if n-1 not in nums:
                m = n + 1
                while m in nums:
                    m += 1
                res = max(res, m-n)
        return res