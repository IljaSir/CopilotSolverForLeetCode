class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] c1 = new int[n];
        int[] c2 = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (ch[i] == '0') {
                    c1[i] = 0;
                    c2[i] = 1;
                } else {
                    c1[i] = 1;
                    c2[i] = 0;
                }
            } else {
                if (ch[i] == '0') {
                    c1[i] = 1;
                    c2[i] = 0;
                } else {
                    c1[i] = 0;
                    c2[i] = 1;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            c1[i] += c1[i - 1];
            c2[i] += c2[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int t1 = c1[n - 1] - c1[i];
            int t2 = c2[n - 1] - c2[i];
            if (i % 2 == 0) {
                t1 += c2[i];
                t2 += c1[i];
            } else {
                t1 += c1[i];
                t2 += c2[i];
            }
            if (i == 0) {
                ans = Math.min(t1, t2);
            } else {
                ans = Math.min(ans, Math.min(t1, t2));
            }
        }
        return ans;
    }
}