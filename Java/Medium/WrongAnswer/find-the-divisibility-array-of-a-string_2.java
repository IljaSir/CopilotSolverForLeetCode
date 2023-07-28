class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int n = word.length();
        int[] res = new int[n];
        int mod = 0;
        for (int i = 0; i < n; i++) {
            mod = (mod * 10 + word.charAt(i) - '0') % m;
            res[i] = mod == 0 ? 1 : 0;
        }
        return res;
    }
}