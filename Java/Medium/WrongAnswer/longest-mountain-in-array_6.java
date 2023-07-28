class Solution {
    public int longestMountain(int[] arr) {
        
        if (arr.length < 3) return 0;
        int max = 0;
        boolean up = false;
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (up) continue;
                else {
                    up = true;
                    start = i - 1;
                }
            } else if (arr[i] < arr[i - 1]) {
                if (up) {
                    max = Math.max(max, i - start + 1);
                    up = false;
                }
            } else {
                up = false;
            }
        }
        return max;
    }
}