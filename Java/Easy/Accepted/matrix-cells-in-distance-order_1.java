class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        int[][] result = new int[rows * cols][2];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[index][0] = i;
                result[index][1] = j;
                index++;
            }
        }
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter) - Math.abs(b[0] - rCenter) - Math.abs(b[1] - cCenter);
            }
        });
        return result;
    }
}