class Solution:
    def maximumANDSum(self, nums: List[int], numSlots: int) -> int:
        
        n = len(nums)
        nums.sort()
        dp = [0] * (1<<n)
        for i in range(1,n+1):
            for j in range(1<<n):
                if j & (1<<(i-1)):
                    dp[j] = dp[j-(1<<(i-1))] + nums[i-1]
        ans = 0
        for i in range(1<<n):
            if bin(i).count('1') == numSlots:
                ans = max(ans, dp[i])
        return ans