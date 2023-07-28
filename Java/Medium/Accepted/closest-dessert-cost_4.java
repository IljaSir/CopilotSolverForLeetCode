class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int[] cost = new int[1];
        cost[0] = Integer.MAX_VALUE;
        for (int baseCost : baseCosts) {
            dfs(toppingCosts, 0, baseCost, target, cost);
        }
        return cost[0];
    }

    private void dfs(int[] toppingCosts, int index, int cost, int target, int[] res) {
        if (Math.abs(target - cost) < Math.abs(target - res[0])) {
            res[0] = cost;
        } else if (Math.abs(target - cost) == Math.abs(target - res[0])) {
            res[0] = Math.min(cost, res[0]);
        }

        if (index == toppingCosts.length) {
            return;
        }

        dfs(toppingCosts, index + 1, cost, target, res);
        dfs(toppingCosts, index + 1, cost + toppingCosts[index], target, res);
        dfs(toppingCosts, index + 1, cost + toppingCosts[index] * 2, target, res);
    }
}