class Solution {
    public String minInteger(String num, int k) {
        
        int n = num.length();
        int[] pos = new int[10];
        char[] ans = new char[n];
        for (int i = 0; i < 10; ++i) {
            pos[i] = -1;
        }
        for (int i = 0; i < n; ++i) {
            int d = num.charAt(i) - '0';
            int best = d;
            for (int j = 0; j < d; ++j) {
                if (pos[j] >= 0 && i - pos[j] <= k) {
                    best = j;
                    break;
                }
            }
            ans[i] = (char)(best + '0');
            k -= i - pos[best];
            pos[best] = i;
        }
        return new String(ans);
    }
}