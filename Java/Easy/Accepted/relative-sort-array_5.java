class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int[] result = new int[arr1.length];
        int[] freq = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            freq[arr1[i]]++;
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (freq[arr2[i]] > 0) {
                result[index++] = arr2[i];
                freq[arr2[i]]--;
            }
        }
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                result[index++] = i;
                freq[i]--;
            }
        }
        return result;
    }
}