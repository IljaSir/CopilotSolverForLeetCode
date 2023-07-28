class Solution:
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        
        
        def get_closest_cost(base_cost, topping_costs, target):
            result = base_cost
            closest = float('inf')
            for i in range(2**len(topping_costs)):
                for j in range(len(topping_costs)):
                    if (i >> j) & 1:
                        result += topping_costs[j]
                if abs(result - target) < abs(closest - target):
                    closest = result
                result = base_cost
            return closest
        
        closest = float('inf')
        for base_cost in baseCosts:
            closest = min(closest, get_closest_cost(base_cost, toppingCosts, target))
        return closest