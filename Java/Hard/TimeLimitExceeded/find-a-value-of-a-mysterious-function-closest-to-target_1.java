class Solution {
    public int closestToTarget(int[] arr, int target) {
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            for (int j = i; j < arr.length; j++) {
                val &= arr[j];
                ans = Math.min(ans, Math.abs(val - target));
            }
        }
        return ans;
    }
}