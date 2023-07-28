class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        nums = set(nums)
        ans = 1
        for num in nums:
            if num-1 not in nums:
                curr = 1
                while num+1 in nums:
                    num += 1
                    curr += 1
                ans = max(ans, curr)
        return ans