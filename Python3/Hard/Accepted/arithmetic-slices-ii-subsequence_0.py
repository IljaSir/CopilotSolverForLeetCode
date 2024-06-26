class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [collections.defaultdict(int) for _ in range(n)]
        ans = 0
        for i in range(n):
            for j in range(i):
                d = nums[i] - nums[j]
                dp[i][d] += 1
                if d in dp[j]:
                    dp[i][d] += dp[j][d]
                    ans += dp[j][d]
        return ans