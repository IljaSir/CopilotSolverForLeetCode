class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        nums.sort()
        n = len(nums)
        dp = [1] * n
        for i in range(1, n):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    dp[i] = max(dp[i], dp[j] + 1)
        max_idx = 0
        for i in range(n):
            if dp[i] > dp[max_idx]:
                max_idx = i
        result = []
        while max_idx != -1:
            result.append(nums[max_idx])
            max_idx = dp[max_idx] - 1
        return result