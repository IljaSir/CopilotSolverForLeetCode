class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int closest = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            int cost = dfs(toppingCosts, target, 0, base);
            if (Math.abs(target - cost) < Math.abs(target - closest)) {
                closest = cost;
            } else if (Math.abs(target - cost) == Math.abs(target - closest)) {
                closest = Math.min(closest, cost);
            }
        }
        return closest;
    }
    
    private int dfs(int[] toppingCosts, int target, int index, int cost) {
        if (index == toppingCosts.length) {
            return cost;
        }
        
        int cost1 = dfs(toppingCosts, target, index + 1, cost);
        int cost2 = dfs(toppingCosts, target, index + 1, cost + toppingCosts[index]);
        int cost3 = dfs(toppingCosts, target, index + 1, cost + toppingCosts[index] * 2);
        
        if (Math.abs(target - cost1) < Math.abs(target - cost2) && Math.abs(target - cost1) < Math.abs(target - cost3)) {
            return cost1;
        } else if (Math.abs(target - cost2) < Math.abs(target - cost1) && Math.abs(target - cost2) < Math.abs(target - cost3)) {
            return cost2;
        } else {
            return cost3;
        }
    }
}