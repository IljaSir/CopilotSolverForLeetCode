class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        
        # sort by cost difference
        sorted_costs = sorted(costs, key=lambda x: abs(x[0] - x[1]), reverse=True)
        # print(sorted_costs)
        total_cost = 0
        n = len(costs) // 2
        a_count = 0
        b_count = 0
        for cost in sorted_costs:
            if cost[0] < cost[1]:
                if a_count < n:
                    total_cost += cost[0]
                    a_count += 1
                else:
                    total_cost += cost[1]
                    b_count += 1
            else:
                if b_count < n:
                    total_cost += cost[1]
                    b_count += 1
                else:
                    total_cost += cost[0]
                    a_count += 1
        return total_cost