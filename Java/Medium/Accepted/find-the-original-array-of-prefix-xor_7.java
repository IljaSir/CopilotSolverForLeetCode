class Solution {
    public int[] findArray(int[] pref) {
        
        int[] ans = new int[pref.length];
        for (int i = 0; i < pref.length; i++) {
            ans[i] = ans[i] ^ pref[i];
            if (i + 1 < pref.length) {
                ans[i + 1] = ans[i + 1] ^ pref[i];
            }
        }
        return ans;
    }
}