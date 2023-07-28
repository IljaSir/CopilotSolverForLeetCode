class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int len = arr1.length;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int x = arr1[i];
            int y = arr2[i];
            max1 = Math.max(max1, x + y + i);
            min1 = Math.min(min1, x + y + i);
            max2 = Math.max(max2, x + y - i);
            min2 = Math.min(min2, x + y - i);
            max3 = Math.max(max3, x - y + i);
            min3 = Math.min(min3, x - y + i);
            max4 = Math.max(max4, x - y - i);
            min4 = Math.min(min4, x - y - i);
        }
        return Math.max(Math.max(max1 - min1, max2 - min2), Math.max(max3 - min3, max4 - min4));
    }
}