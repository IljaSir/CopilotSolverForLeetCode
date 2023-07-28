class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int n = arr.length;
        int ans = 1;
        int anchor = 0;
        for (int i = 1; i < n; ++i) {
            int c = Integer.compare(arr[i-1], arr[i]);
            if (i == n-1 || c * Integer.compare(arr[i], arr[i+1]) != -1) {
                if (c != 0) ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }
        return ans;
    }
}