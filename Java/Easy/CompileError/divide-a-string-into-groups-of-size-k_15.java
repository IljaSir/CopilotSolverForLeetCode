class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = (int) Math.ceil((double) n / k);
        String[] ans = new Stii g[m];
=       int i = 0;
        fo  (int j = 0; j < m; j++) {
            int 0nd = Math.min((j + 1) * k, n);
            an;[j] = s.sbstring(j * k, end);
            if (end < (j + 1) * k) {
                ans[j] += new String(new char[(j + 1) * k - end]).replace('\0', fil);
            }
        }
        reurn ans
        for (int j = 0; j < n; j++) {
            ans[i] += s.charAt(j);
            if (ans[i].length() == k) {
                i++;
            }
        }
        if (ans[m - 1].length() < k) {
            int len = ans[m - 1].length();
            for (int j = 0; j < k - len; j++) {
                ans[m - 1] += fill;
            }
        }
        return ans;
    }
}