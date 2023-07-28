class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int res = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            int diff = Math.abs(base - target);
            if (diff < minDiff) {
                minDiff = diff;
                res = base;
            }
            if (diff == 0) {
                return res;
            }
            int[] arr = new int[toppingCosts.length];
            dfs(toppingCosts, arr, base, target, 0, res, minDiff);
        }
        return res;
    }
    private void dfs(int[] toppingCosts, int[] arr, int base, int target, int index, int res, int minDiff) {
        if (index == toppingCosts.length) {
            int sum = base;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] * toppingCosts[i];
            }
            int diff = Math.abs(sum - target);
            if (diff < minDiff) {
                minDiff = diff;
                res = sum;
            } else if (diff == minDiff && sum < res) {
                res = sum;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            arr[index] = i;
            dfs(toppingCosts, arr, base, target, index + 1, res, minDiff);
        }
    }
}