class Solution:
    def jump(self, nums: List[int]) -> int:
        
        # DP
        # dp[i] = min(dp[i], dp[j] + 1) for j in range(i - nums[i], i)
        # dp[0] = 0
        # dp[i] = inf for i > 0
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        # dp = [float('inf')] * len(nums)
        # dp[0] = 0
        # for i in range(1, len(nums)):
        #     for j in range(i - nums[i], i):
        #         dp[i] = min(dp[i], dp[j] + 1)
        # return dp[-1]
        
        # Greedy
        # Time  complexity: O(N)
        # Space complexity: O(1)
        # i, end, farthest = 0, 0, 0
        # while farthest < len(nums) - 1:
        #     farthest = max(farthest, i + nums[i])
        #     if i == end:
        #         end = farthest
        #         i += 1
        # return i
        
        # Greedy
        # Time  complexity: O(N)
        # Space complexity: O(1)
        farthest = end = jumps = 0
        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            if i == end:
                end = farthest
                jumps += 1
        return jumps