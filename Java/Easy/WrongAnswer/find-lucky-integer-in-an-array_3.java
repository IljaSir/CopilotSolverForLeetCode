class Solution {
    public int findLucky(int[] arr) {
        
        int[] count = new int[501];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int max = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == i) {
                max = i;
            }
        }
        return max;
    }
}