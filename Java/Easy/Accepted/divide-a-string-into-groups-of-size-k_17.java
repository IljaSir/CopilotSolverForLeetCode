class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = (int) Math.ceil((double) n / k);
        String[] ans = new String[m];
        int i = 0;
        for (int j = 0; j < m; j++) {
            int end = Math.min((j + 1) * k, n);
            ans[j] = s.substring(j * k, end);
            if (end < (j + 1) * k) {
                ans[j] += new String(new char[(j + 1) * k - end]).replace('\0', fill);
            }
        }
        return ans;
    }
}