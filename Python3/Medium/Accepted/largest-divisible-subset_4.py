class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        nums.sort()
        n = len(nums)
        dp = [1] * n
        pre = [-1] * n
        for i in range(n):
            for j in range(i):
                if nums[i] % nums[j] == 0 and dp[i] < dp[j] + 1:
                    dp[i] = dp[j] + 1
                    pre[i] = j
        idx = dp.index(max(dp))
        res = []
        while idx != -1:
            res.append(nums[idx])
            idx = pre[idx]
        return res