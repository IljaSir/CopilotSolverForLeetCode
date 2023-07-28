class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int baseCost : baseCosts) {
            int sum = baseCost;
            int diff = Math.abs(target - sum);
            if (diff < min) {
                min = diff;
                result = sum;
            }
            for (int toppingCost : toppingCosts) {
                sum += toppingCost;
                diff = Math.abs(target - sum);
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                for (int toppingCost2 : toppingCosts) {
                    sum += toppingCost2;
                    diff = Math.abs(target - sum);
                    if (diff < min) {
                        min = diff;
                        result = sum;
                    }
                    sum -= toppingCost2;
                }
                sum -= toppingCost;
            }
        }
        return result;
    }
}