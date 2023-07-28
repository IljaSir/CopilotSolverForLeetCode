class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        n = len(nums)
        dp = [1] * n
        prev = [-1] * n
        for i in range(1, n):
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