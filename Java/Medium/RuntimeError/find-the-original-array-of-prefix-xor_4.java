class Solution {
    public int[] findArray(int[] pref) {
        
        int[] arr = new int[pref.length];
        for (int i = 0; i < pref.length; i++) {
            arr[i] = pref[i] ^ arr[i - 1];
        }
        return arr;
    }
}