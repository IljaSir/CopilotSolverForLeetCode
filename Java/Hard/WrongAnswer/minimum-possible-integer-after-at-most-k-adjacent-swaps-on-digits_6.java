class Solution {
    public String minInteger(String num, int k) {
        
        int n = num.length();
        int[] pos = new int[10];
        for (int i = 0; i < 10; ++i) {
            pos[i] = -1;
        }
        char[] ans = new char[n];
        for (int i = 0; i < n; ++i) {
            int d = num.charAt(i) - '0';
            int best = -1, bestPos = n + 1;
            for (int j = 0; j < d; ++j) {
                if (pos[j] != -1 && i - pos[j] <= k) {
                    if (pos[j] < bestPos) {
                        best = j;
                        bestPos = pos[j];
                    }
                }
            }
            if (best != -1) {
                ans[bestPos] = (char)('0' + d);
                pos[d] = bestPos;
                k -= bestPos - i;
            } else {
                ans[i] = num.charAt(i);
                pos[d] = i;
            }
        }
        return new String(ans);
    }
}