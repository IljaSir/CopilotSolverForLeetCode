class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        
        costs.sort(key=lambda x: abs(x[0] - x[1]), reverse=True)
        n = len(costs) // 2
        a = 0
        b = 0
        total = 0
        for cost in costs:
            if cost[0] < cost[1]:
                if a < n:
                    total += cost[0]
                    a += 1
                else:
                    total += cost[1]
                    b += 1
            else:
                if b < n:
                    total += cost[1]
                    b += 1
                else:
                    total += cost[0]
                    a += 1
        return total