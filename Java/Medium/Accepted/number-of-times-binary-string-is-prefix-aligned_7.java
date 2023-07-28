class Solution {
    public int numTimesAllBlue(int[] flips) {
        
        int n = flips.length;
        int[] arr = new int[n + 1];
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            arr[flips[i]]++;
            max = Math.max(max, flips[i]);
            if (max == i + 1) {
                res++;
            }
        }
        return res;
    }
}