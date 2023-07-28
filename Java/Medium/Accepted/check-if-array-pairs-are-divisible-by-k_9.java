class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] count = new int[k];
        for (int x : arr) {
            count[(x % k + k) % k]++; //count the number of elements with the same remainder
        }
        if (count[0] % 2 == 1) {
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