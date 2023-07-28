class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        dp = [0] * len(nums)
        prev = [-1] * len(nums)
        for i in range(len(nums)):
            dp[i] = 1
            for j in range(i):
                if nums[i] % nums[j] == 0 and dp[j] + 1 > dp[i]:
                    dp[i] = dp[j] + 1
                    prev[i] = j
        max_idx = dp.index(max(dp))
        ans = []
        while max_idx != -1:
            ans.append(nums[max_idx])
            max_idx = prev[max_idx]
        return ans