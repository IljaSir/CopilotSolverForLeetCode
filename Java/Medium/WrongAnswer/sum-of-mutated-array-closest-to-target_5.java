class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int sum = 0;
        int max = 0;
        for (int a: arr) {
            sum += a;
            max = Math.max(max, a);
        }
        if (sum <= target) return max;
        int l = 0, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            sum = 0;
            for (int a: arr) {
                sum += Math.min(mid, a);
            }
            if (sum >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        sum = 0;
        for (int a: arr) {
            sum += Math.min(l, a);
        }
        return Math.abs(sum - target) <= Math.abs(sum - l - target) ? l : l + 1;
    }
}