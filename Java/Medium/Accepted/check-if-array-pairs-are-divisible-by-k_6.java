class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int n = arr.length;
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            int mod = arr[i] % k;
            if (mod < 0) {
                mod += k;
            }
            count[mod]++;
        }
        if (count[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < (k + 1) / 2; i++) {
            if (count[i] != count[k - i]) {
                return false;
            }
        }
        return true;
    }
}