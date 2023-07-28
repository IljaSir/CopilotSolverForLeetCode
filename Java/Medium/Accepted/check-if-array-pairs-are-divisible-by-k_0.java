class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] % k + k) % k]++;
        }
        if (count[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (count[i] != count[k - i]) {
                return false;
            }
        }
        return true;
    }
}