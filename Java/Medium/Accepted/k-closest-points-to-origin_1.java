class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
            }
        });
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }
}