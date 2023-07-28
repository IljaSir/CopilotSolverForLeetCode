class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int[] counter = new int[1001];
        for (int i : arr1) {
            counter[i]++;
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            while (counter[i]-- > 0) {
                result[index++] = i;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (counter[i]-- > 0) {
                result[index++] = i;
            }
        }
        return result;
    }
}