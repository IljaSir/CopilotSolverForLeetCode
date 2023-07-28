class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = n / k;
        if (n % k != 0) {
            m++;
        }
        String[] ans = new String[m];
        int i = 0;
        int j = 0;
        while (i < n) {
            ans[j++] = s.substring(i, Math.min(i + k, n));
            i += k;
        }
        if (n % k != 0) {
            ans[j - 1] = ans[j - 1] + new String(new char[k - n % k]).replace('\0', fill);
        }
        return ans;
    }
}