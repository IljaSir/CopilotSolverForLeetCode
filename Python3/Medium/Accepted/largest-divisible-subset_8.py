class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        nums.sort()
        n = len(nums)
        dp = [1] * n
        pre = [-1] * n
        max_length = max_index = 0
        for i in range(n):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        pre[i] = j
            if dp[i] > max_length:
                max_length = dp[i]
                max_index = i
        res = []
        while max_index != -1:
            res.append(nums[max_index])
            max_index = pre[max_index]
        return res