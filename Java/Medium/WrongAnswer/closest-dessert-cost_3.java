class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {
            int cost = baseCosts[i];
            if (Math.abs(cost - target) < min) {
                min = Math.abs(cost - target);
                ans = cost;
            }
            for (int j = 0; j < toppingCosts.length; j++) {
                cost += toppingCosts[j];
                if (Math.abs(cost - target) < min) {
                    min = Math.abs(cost - target);
                    ans = cost;
                }
                for (int k = j + 1; k < toppingCosts.length; k++) {
                    cost += toppingCosts[k];
                    if (Math.abs(cost - target) < min) {
                        min = Math.abs(cost - target);
                        ans = cost;
                    }
                    cost -= toppingCosts[k];
                }
                cost -= toppingCosts[j];
            }
        }
        return ans;
    }
}