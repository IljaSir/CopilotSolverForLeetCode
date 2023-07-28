class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        dp = [1] * len(nums)
        pre = [-1] * len(nums)
        max_len = 0
        max_index = 0
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    if dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        pre[i] = j
            if dp[i] > max_len:
                max_len = dp[i]
                max_index = i
        res = []
        while max_index != -1:
            res.append(nums[max_index])
            max_index = pre[max_index]
        return res