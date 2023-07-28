class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        int res = 0;
        double cur = 0;
        for (int i = 0; i < n; i++) {
            double time = (double) (target - arr[i][0]) / arr[i][1];
            if (time > cur) {
                res++;
                cur = time;
            }
        }
        return res;
    }
}