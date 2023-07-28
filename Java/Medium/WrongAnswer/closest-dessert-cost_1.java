class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int closest = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            closest = Math.min(closest, closestCost(base, toppingCosts, target, 0));
        }
        return closest;
    }
    
    private int closestCost(int base, int[] toppingCosts, int target, int index) {
        if (index == toppingCosts.length) {
            return base;
        }
        int cost1 = closestCost(base, toppingCosts, target, index + 1);
        int cost2 = closestCost(base + toppingCosts[index], toppingCosts, target, index + 1);
        int cost3 = closestCost(base + toppingCosts[index] * 2, toppingCosts, target, index + 1);
        return getClosest(target, cost1, cost2, cost3);
    }
    
    private int getClosest(int target, int... costs) {
        int closest = Integer.MAX_VALUE;
        for (int cost : costs) {
            if (Math.abs(cost - target) < Math.abs(closest - target)) {
                closest = cost;
            } else if (Math.abs(cost - target) == Math.abs(closest - target) && cost < closest) {
                closest = cost;
            }
        }
        return closest;
    }
}