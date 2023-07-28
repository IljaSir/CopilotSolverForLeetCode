class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int n = word.length();
        int[] res = new int[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = (num * 10 + word.charAt(i) - '0') % m;
            res[i] = num == 0 ? 1 : 0;
        }
        return res;
    }
}