class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        n = len(nums)
        pre_sum = [0]
        for num in nums:
            pre_sum.append(pre_sum[-1] + num)
        dp = [pre_sum[n]/n]
        for _ in range(k-1):
            dp_next = [0]*n
            for i in range(n):
                for j in range(i+1, n+1):
                    dp_next[i] = max(dp_next[i], dp[j-1] + (pre_sum[j]-pre_sum[i])/(j-i))
            dp = dp_next
        return dp[0]