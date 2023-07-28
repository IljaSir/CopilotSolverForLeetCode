class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        
        costs.sort(key=lambda cost: cost[0] - cost[1])
        sum = 0
        for i in range(len(costs)):
            if i < len(costs) // 2:
                sum += costs[i][0]
            else:
                sum += costs[i][1]
        return sum