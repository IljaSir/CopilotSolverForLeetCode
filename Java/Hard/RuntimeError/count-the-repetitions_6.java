class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        
        int i = 0, j = 0, cnt = 0;
        int[] next = new int[s2.length()];
        int[] repeat = new int[s2.length()];
        while (i < n1) {
            if (s1.charAt(j) == s2.charAt(cnt)) {
                ++cnt;
                if (cnt == s2.length()) {
                    cnt = 0;
                    ++repeat[i];
                }
            }
            ++j;
            if (j == s1.length()) {
                j = 0;
                ++i;
                next[i] = cnt;
            }
        }
        int ans = repeat[n1] / n2;
        int rest = repeat[n1] % n2;
        int start = 0, end = 0;
        for (int k = 0; k < n1; ++k) {
            if (next[k] == rest) {
                start = k;
                break;
            }
        }
        for (int k = n1 - 1; k >= 0; --k) {
            if (next[k] == rest) {
                end = k;
                break;
            }
        }
        ans += (repeat[end] - repeat[start]) / n2;
        return ans;
    }
}