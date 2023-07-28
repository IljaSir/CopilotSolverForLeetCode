class Solution {
    public String largestPalindromic(String num) {
        
        int[] cnts = new int[10];
        int len = num.length();
        for (int i = 0; i < len; i++) {
            cnts[num.charAt(i) - '0']++;
        }
        int[] ans = new int[len];
        int idx = 0;
        for (int i = 9; i >= 0; i--) {
            while (cnts[i] > 0) {
                ans[idx++] = i;
                cnts[i]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}