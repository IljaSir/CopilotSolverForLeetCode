class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        
        n = len(nums)
        res = 0
        for i in range(1, n):
            if nums[i] == nums[i-1]:
                res += min(cost[i], cost[i-1])
                cost[i] = max(cost[i], cost[i-1])
        return res