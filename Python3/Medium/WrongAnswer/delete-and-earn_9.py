class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        c = collections.Counter(nums)
        d = {}
        for num in c:
            d[num] = num * c[num]
        keys = sorted(d.keys())
        dp = {}
        for i, num in enumerate(keys):
            dp[i] = d[num]
            if i - 1 >= 0:
                dp[i] = max(dp[i], dp[i - 1])
            if i - 2 >= 0:
                dp[i] = max(dp[i], dp[i - 2] + d[num])
        return dp[len(keys) - 1]