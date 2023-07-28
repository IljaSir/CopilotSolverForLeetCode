class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        
        # dp[i][j] = dp[i-1][j] + dp[i-1][j|nums[i]]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR equal to j|nums[i]
        # dp[i][j] = number of subsets with bitwise OR equal to j
        # dp[i][j|nums[i]] = number of subsets with bitwise OR