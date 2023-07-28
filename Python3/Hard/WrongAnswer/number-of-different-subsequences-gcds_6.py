class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        nums = sorted(set(nums))
        n = len(nums)
        dp = [0]*(nums[-1]+1)
        for i in range(n):
            for j in range(nums[i], nums[-1]+1, nums[i]):
                dp[j] = 1
        res = 0
        for i in range(1, nums[-1]+1):
            if dp[i] == 1:
                for j in range(i+i, nums[-1]+1, i):
                    dp[j] = 0
                res += 1
        return res