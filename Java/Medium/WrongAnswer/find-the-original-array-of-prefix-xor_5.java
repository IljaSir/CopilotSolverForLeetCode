class Solution {
    public int[] findArray(int[] pref) {
        
        int[] ret = new int[pref.length];
        ret[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            ret[i] = ret[i - 1] ^ pref[i];
        }
        return ret;
    }
}