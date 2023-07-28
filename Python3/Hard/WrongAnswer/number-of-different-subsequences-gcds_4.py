class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        nums = set(nums)
        ans = 0
        for i in range(1, max(nums) + 1):
            if all(i % x == 0 for x in nums):
                ans += 1
        return ans