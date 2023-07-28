class Solution {
    public int findLucky(int[] arr) {
        
        int[] freq = new int[501];
        for (int x : arr) {
            freq[x]++;
        }
        int ans = -1;
        for (int i = 1; i < 501; i++) {
            if (freq[i] == i) {
                ans = i;
            }
        }
        return ans;
    }
}