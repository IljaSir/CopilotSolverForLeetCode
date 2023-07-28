class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return 0
        res = 0
        for i in range(1, n):
            if nums[i] == nums[i-1]:
                res += min(cost[i], cost[i-1])
                if cost[i] < cost[i-1]:
                    nums[i] += 1
                else:
                    nums[i-1] += 1
        return res