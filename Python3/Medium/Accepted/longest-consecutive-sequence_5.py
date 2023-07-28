class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        nums = set(nums)
        ans = 1
        for num in nums:
            if num-1 not in nums:
                cur = num
                while cur+1 in nums:
                    cur += 1
                ans = max(ans, cur-num+1)
        return ans