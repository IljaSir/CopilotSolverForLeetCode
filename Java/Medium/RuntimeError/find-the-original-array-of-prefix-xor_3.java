class Solution {
    public int[] findArray(int[] pref) {
        
        int n = pref.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pref[i] ^ arr[i - 1];
        }
        return arr;
    }
}