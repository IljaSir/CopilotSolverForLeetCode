class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int max = arr[2];
        int mid = arr[1];
        int min = arr[0];
        int res = min;
        max -= min;
        if (max >= mid) {
            res += mid;
        } else {
            res += max;
            res += (mid - max) / 2;
        }
        return res;
    }
}