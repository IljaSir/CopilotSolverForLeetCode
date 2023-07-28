class Solution {
    public int closestToTarget(int[] arr, int target) {
        
        int result = Integer.MAX_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int xor = arr[i];
            for (int j = i; j < n; j++) {
                xor &= arr[j];
                result = Math.min(result, Math.abs(xor - target));
            }
        }
        return result;
    }
}