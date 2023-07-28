class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        
        # Counting sort
        sorted_costs = [0] * (max(costs) + 1)
        for cost in costs:
            sorted_costs[cost] += 1
        count = 0
        for i in range(len(sorted_costs)):
            if coins >= i:
                if sorted_costs[i] <= coins // i:
                    count += sorted_costs[i]
                    coins -= sorted_costs[i] * i
                else:
                    count += coins // i
                    break
        return count