class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        
        if not nums: return []
        nums.sort()
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    dp[i] = max(dp[i], dp[j] + 1)
        max_index = dp.index(max(dp))
        res = []
        while max_index >= 0 and dp[max_index] > 0:
            res.append(nums[max_index])
            for i in range(max_index, -1, -1):
                if nums[max_index] % nums[i] == 0 and dp[i] == dp[max_index] - 1:
                    max_index = i
                    break
        return res