class Solution {
    public int findLucky(int[] arr) {
        
        int[] freq = new int[501];
        for (int i: arr) {
            freq[i]++;
        }
        int res = -1;
        for (int i = 1; i < 501; i++) {
            if (freq[i] == i) {
                res = i;
            }
        }
        return res;
    }
}