class Solution {
    public String minInteger(String num, int k) {
        
        int n = num.length();
        int[] pos = new int[10];
        char[] ans = new char[n];
        for (int i = 0; i < n; ++i) {
            pos[num.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < n; ++i) {
            for (int d = 0; d < 10; ++d) {
                if (pos[d] < i || pos[d] - i > k) {
                    continue;
                }
                k -= pos[d] - i;
                ans[i] = (char) ('0' + d);
                for (int d2 = 0; d2 < 10; ++d2) {
                    if (pos[d2] < pos[d]) {
                        pos[d2]++;
                    }
                }
                pos[d] = n;
                break;
            }
        }
        return new String(ans);
    }
}