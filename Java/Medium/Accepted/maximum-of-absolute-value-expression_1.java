class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int[] a = new int[arr1.length];
        int[] b = new int[arr1.length];
        int[] c = new int[arr1.length];
        int[] d = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            a[i] = arr1[i] + arr2[i] + i;
            b[i] = arr1[i] + arr2[i] - i;
            c[i] = arr1[i] - arr2[i] + i;
            d[i] = arr1[i] - arr2[i] - i;
        }
        return Math.max(Math.max(max(a) - min(a), max(b) - min(b)), Math.max(max(c) - min(c), max(d) - min(d)));
    }
    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    private int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}