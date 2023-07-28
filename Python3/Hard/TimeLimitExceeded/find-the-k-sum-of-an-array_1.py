class Solution:
    def kSum(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        n = len(nums)
        dp = [0] * (1 << n)
        for i in range(1, 1 << n):
            for j in range(n):
                if i & (1 << j):
                    dp[i] = dp[i ^ (1 << j)] + nums[j]
                    break
        dp.sort(reverse=True)
        return dp[k - 1]