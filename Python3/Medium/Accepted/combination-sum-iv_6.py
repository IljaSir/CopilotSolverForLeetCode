class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        dp = [0] * (target+1)
        dp[0] = 1
        for i in range(target+1):
            for j in nums:
                if j > i:
                    break
                dp[i] += dp[i-j]
        return dp[-1]