class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] remainder = new int[k];
        for (int i = 0; i < arr.length; i++) {
            remainder[((arr[i] % k) + k) % k]++;
        }
        if (remainder[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (remainder[i] != remainder[k - i]) {
                return false;
            }
        }
        return true;
    }
}