class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = n / k;
        if (n % k != 0) {
            m++;
        }
        if (n [] res = new String[m];
        for (int i = 0; i < m; i++) {
            if (i < m - 1) {
                res[i] = s.substring(i * k, (i + 1) * k);
            } else {
                res[i] = s.substring(i * k);
                while (res[i].length() < k) {
                    res[i] += fill;
                }
            }
        }
        return res;
    }
}