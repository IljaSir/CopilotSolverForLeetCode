class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int closest = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            int cost = base;
            closest = Math.abs(target - cost) < Math.abs(target - closest) ? cost : closest;
            for (int topping : toppingCosts) {
                cost += topping;
                closest = Math.abs(target - cost) < Math.abs(target - closest) ? cost : closest;
                cost += topping;
                closest = Math.abs(target - cost) < Math.abs(target - closest) ? cost : closest;
                cost -= topping;
            }
        }
        return closest;
    }
}