class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        n = len(nums) // 3
        nums.sort()
        ans = float('inf')
        for i in range(n):
            ans = min(ans, sum(nums[i+n:]) - sum(nums[:i+n]))
        return ans