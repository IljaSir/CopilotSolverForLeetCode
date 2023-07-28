class Solution {
    public int[] findArray(int[] pref) {
        
        int[] res = new int[pref.length];
        int x = 0;
        for (int i = 0; i < pref.length; i++) {
            x = x ^ pref[i];
            res[i] = x;
        }
        return res;
    }
}