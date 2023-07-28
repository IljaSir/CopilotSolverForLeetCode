class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        
        n = len(nums)
        sums = [0] * (n+1)
        for i in range(n):
            sums[i+1] = sums[i] + nums[i]
        def calc(i):
            return sums[i+k] - sums[i]
        dp = [[0, 0, 0] for _ in range(n+1)]
        for i in range(n, -1, -1):
            for j in range(2, -1, -1):
                if i + k > n: continue
                dp[i][j] = max(dp[i][j], dp[i+k][j+1] + calc(i))
                dp[i][j] = max(dp[i][j], dp[i+1][j])
        res = []
        i = 0
        for j in range(3):
            while i + k <= n and dp[i][j] == dp[i+1][j]:
                i += 1
            res.append(i)
            i += k
        return res