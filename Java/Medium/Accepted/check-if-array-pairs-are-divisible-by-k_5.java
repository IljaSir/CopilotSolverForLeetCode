class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] mods = new int[k];
        for (int n : arr) {
            mods[(n % k + k) % k]++;
        }
        if (mods[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (mods[i] != mods[k - i]) {
                return false;
            }
        }
        return true;
    }
}