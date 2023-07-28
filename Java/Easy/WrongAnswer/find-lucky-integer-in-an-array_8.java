class Solution {
    public int findLucky(int[] arr) {
        
        int[] count = new int[501];
        for (int i : arr) {
            count[i] += 1;
        }
        int max = -1;
        for (int i = 0; i <= 500; i++) {
            if (count[i] == i) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}