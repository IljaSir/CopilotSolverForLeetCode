class Solution {
    public int findLucky(int[] arr) {
        
        int[] count = new int[501];
        for (int n: arr) {
            count[n]++;
        }
        int res = -1;
        for (int i = 1; i < 501; i++) {
            if (count[i] == i) {
                res = i;
            }
        }
        return res;
    }
}