class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        # O(n^2) time, O(n^2) space
        # dp[i][diff]: number of arithmetic sequences that end with nums[i] and have difference diff
        dp = [defaultdict(int) for _ in nums]
        ans = 0
        for i in range(len(nums)):
            for j in range(i):
                diff = nums[i] - nums[j]
                ans += dp[j][diff]
                dp[i][diff] += dp[j][diff] + 1
        return ans