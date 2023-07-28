class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int min = Integer.MAX_VALUE;
        int minCost = 0;
        for(int baseCost : baseCosts){
            int cost = getMinCost(baseCost, toppingCosts, 0, target);
            if(Math.abs(target - cost) < min){
                min = Math.abs(target - cost);
                minCost = cost;
            }
            else if(Math.abs(target - cost) == min){
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }
    
    public int getMinCost(int baseCost, int[] toppingCosts, int index, int target){
        if(index == toppingCosts.length){
            return baseCost;
        }
        int cost = getMinCost(baseCost, toppingCosts, index + 1, target);
        int cost1 = getMinCost(baseCost + toppingCosts[index], toppingCosts, index + 1, target);
        int cost2 = getMinCost(baseCost + 2 * toppingCosts[index], toppingCosts, index + 1, target);
        if(Math.abs(target - cost) < Math.abs(target - cost1)){
            if(Math.abs(target - cost) < Math.abs(target - cost2)){
                return cost;
            }
            else{
                return cost2;
            }
        }
        else{
            if(Math.abs(target - cost1) < Math.abs(target - cost2)){
                return cost1;
            }
            else{
                return cost2;
            }
        }
    }
}