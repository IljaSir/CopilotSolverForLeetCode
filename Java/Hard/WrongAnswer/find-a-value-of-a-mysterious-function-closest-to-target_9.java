class Solution {
    public int closestToTarget(int[] arr, int target) {
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0, cur = 0; i < arr.length; ++i, cur = 0) {
            for (int j = i; j < arr.length; ++j) {
                cur &= arr[j];
                ans = Math.min(ans, Math.abs(cur - target));
            }
        }
        return ans;
    }
}