class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        
        # 1st solution: time limit exceeded
        # n = len(nums)
        # def dfs(nums, index, n):
        #     if index == n - 1:
        #         return max(nums)
        #     ans = float("inf")
        #     for i in range(1, n):
        #         if nums[i] > 0:
        #             nums[i] -= 1
        #             nums[i-1] += 1
        #             ans = min(ans, dfs(nums, index+1, n))
        #             nums[i] += 1
        #             nums[i-1] -= 1
        #     return ans
        # return dfs(nums, 0, n)

        # 2nd solution: time limit exceeded
        # n = len(nums)
        # def dfs(nums, index, n):
        #     if index == n - 1:
        #         return max(nums)
        #     ans = float("inf")
        #     for i in range(1, n):
        #         if nums[i] > 0:
        #             nums[i] -= 1
        #             nums[i-1] += 1
        #             ans = min(ans, dfs(nums, index+1, n))
        #             nums[i] += 1
        #             nums[i-1] -= 1
        #     return ans
        # return dfs(nums, 0, n)

        # 3rd solution: time limit exceeded
        # n = len(nums)
        # def dfs(nums, index, n):
        #     if index == n - 1:
        #         return max(nums)
        #     ans = float("inf")
        #     for i in range(1, n):
        #         if nums[i] > 0:
        #             nums[i] -= 1
        #             nums[i-1] += 1
        #             ans = min(ans, dfs(nums, index+1, n))
        #             nums[i] += 1
        #             nums[i-1] -= 1
        #     return ans
        # return dfs(nums, 0, n)

        # 4th solution: time limit exceeded
        # n = len(nums)
        # def dfs(nums, index, n):
        #