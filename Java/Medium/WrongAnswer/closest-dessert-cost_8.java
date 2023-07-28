class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int min = Integer.MAX_VALUE;
        int minCost = 0;
        for (int baseCost: baseCosts) {
            int cost = closestCost(baseCost, toppingCosts, target, 0, 0);
            if (Math.abs(cost - target) < min) {
                min = Math.abs(cost - target);
                minCost = cost;
            }
        }
        return minCost;
    }
    
    private int closestCost(int baseCost, int[] toppingCosts, int target, int index, int cost) {
        if (index == toppingCosts.length) {
            return cost + baseCost;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i++) {
            int newCost = closestCost(baseCost, toppingCosts, target, index + 1, cost + i * toppingCosts[index]);
            if (Math.abs(newCost - target) < min) {
                min = Math.abs(newCost - target);
                cost = newCost;
            }
        }
        return cost;
    }
}