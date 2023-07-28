class Solution {
    public int findLucky(int[] arr) {
        
        int[] counts = new int[501];
        for (int n : arr) {
            counts[n]++;
        }
        for (int i = counts.length - 1; i >= 1; i--) {
            if (counts[i] == i) {
                return i;
            }
        }
        return -1;
    }
}