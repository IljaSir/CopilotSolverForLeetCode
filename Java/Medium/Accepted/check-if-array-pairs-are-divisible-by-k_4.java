class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] map = new int[k];
        for (int i : arr) {
            map[(i % k + k) % k]++;
        }
        for (int i = 1; i < k; i++) {
            if (map[i] != map[k - i]) {
                return false;
            }
        }
        return map[0] % 2 == 0;
    }
}