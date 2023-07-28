class Solution {
    public int closestToTarget(int[] arr, int target) {
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = i; j < arr.length; j++) {
                tmp &= arr[j];
                ans = Math.min(ans, Math.abs(tmp - target));
            }
        }
        return ans;
    }
}