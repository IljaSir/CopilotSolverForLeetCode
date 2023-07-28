class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        n = len(nums) // 3
        nums.sort()
        ans = 10**6
        for i in range(n):
            ans = min(ans, nums[-2*n+i] - nums[i])
        return ans