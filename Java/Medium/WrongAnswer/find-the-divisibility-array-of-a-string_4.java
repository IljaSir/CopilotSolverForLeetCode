class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int n = word.length();
        int[] ans = new int[n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = (r * 10 + word.charAt(i) - '0') % m;
            ans[i] = r == 0 ? 1 : 0;
        }
        return ans;
    }
}