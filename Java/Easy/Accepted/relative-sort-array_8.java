class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int[] count = new int[1001];
        for (int i : arr1) {
            count[i] ++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            while (count[i] > 0) {
                res[index ++] = i;
                count[i] --;
            }
        }
        for (int i = 0; i <= 1000; i ++) {
            while (count[i] > 0) {
                res[index ++] = i;
                count[i] --;
            }
        }
        return res;
    }
}