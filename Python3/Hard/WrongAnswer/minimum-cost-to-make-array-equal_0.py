class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        
        res = 0
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                res += min(cost[i], cost[i-1])
                cost[i] = max(cost[i], cost[i-1])
        return res