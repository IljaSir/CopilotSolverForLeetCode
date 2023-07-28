class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int[] arr = new int[1001];
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (arr[arr2[i]] > 0) {
                res[index++] = arr2[i];
                arr[arr2[i]]--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                res[index++] = i;
                arr[i]--;
            }
        }
        return res;
    }
}