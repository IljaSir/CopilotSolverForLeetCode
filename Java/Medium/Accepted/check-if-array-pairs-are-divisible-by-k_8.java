class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] reminder = new int[k];
        for (int i = 0; i < arr.length; i++) {
            reminder[(arr[i] % k + k) % k]++;
        }
        
        if (reminder[0] % 2 != 0) return false;
        for (int i = 1; i < k; i++) {
            if (reminder[i] != reminder[k - i]) return false;
        }
        return true;
    }
}