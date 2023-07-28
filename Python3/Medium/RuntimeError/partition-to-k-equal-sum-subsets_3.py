class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        
        nums.sort(reverse=True)
        target, rem = divmod(sum(nums), k)
        if rem:
            return False
        n = len(nums)
        dp = [[False] * (1 << n) for _ in range(k)]
        dp[0][0] = True
        for i in range(k):
            for state in range(1 << n):
                if dp[i][state]:
                    continue
                for j in range(n):
                    if state & (1 << j) or nums[j] > target:
                        continue
                    if i == 0 and j > 0 and nums[j] == nums[j - 1]:
                        continue
                    if state & (1 << (j - 1)) and nums[j] == nums[j - 1]:
                        continue
                    dp[i][state | (1 << j)] = dp[i][state] if nums[j] == target else dp[i - 1][state]
        return dp[-1][-1]